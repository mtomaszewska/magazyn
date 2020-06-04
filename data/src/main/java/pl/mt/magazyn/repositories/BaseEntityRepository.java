package pl.mt.magazyn.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mt.magazyn.models.BaseEntity;

public interface BaseEntityRepository<E extends BaseEntity> extends CrudRepository<E, Long> {
}
