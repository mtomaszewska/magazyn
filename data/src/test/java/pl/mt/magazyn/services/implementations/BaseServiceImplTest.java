package pl.mt.magazyn.services.implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import pl.mt.magazyn.models.BaseEntity;
import pl.mt.magazyn.repositories.BaseEntityRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

abstract class BaseServiceImplTest <E extends BaseEntity> {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        //given
        E expected = create();
        when(repository().save(expected)).thenReturn(expected);
        //when
        E actual = service().save(expected);
        //then
        assertEquals(actual, expected);
        verify(repository(), times(1)).save(expected);
    }

    @Test
    void saveNull() {
        //given
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service().save(null));
    }

    @Test
    void all() {
        //given
        Set<E> expected = new HashSet<>();
        E e1 = create();
        E e2 = create();
        E e3 = create();
        expected.add(e1);
        expected.add(e2);
        expected.add(e3);
        when(repository().findAll()).thenReturn(expected);
        //when
        Set<E> actual = service().all();
        //then
        assertEquals(actual, expected);

    }

    abstract E create();
    abstract BaseServiceImpl<E> service();
    abstract BaseEntityRepository<E> repository();
}