package pl.mt.magazyn.services;

import pl.mt.magazyn.models.BaseEntity;

import java.util.Set;

public interface BaseService<E extends BaseEntity> {
    E save(E e);
    Set<E> all();
}
