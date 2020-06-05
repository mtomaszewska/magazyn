package pl.mt.magazyn.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mt.magazyn.models.BaseEntity;
import pl.mt.magazyn.repositories.BaseEntityRepository;

import java.util.Set;

public abstract class BaseServiceImpl<E extends BaseEntity> {

    @Autowired
    protected BaseEntityRepository<E> repository;

    public BaseServiceImpl(BaseEntityRepository<E> repository) {
        this.repository = repository;
    }

    public E save(E e) {
        if(e != null){
            return repository.save(e);
        }else{
            throw new IllegalArgumentException("cannot be null");
        }
    }

    public Set<E> all() {
        return repository.findAll();
    }
}
