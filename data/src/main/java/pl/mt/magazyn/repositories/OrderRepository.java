package pl.mt.magazyn.repositories;

import pl.mt.magazyn.models.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends BaseEntityRepository<Order> {
    List<Order> findByDateBetweenOrderByDate(LocalDateTime from, LocalDateTime to);
}
