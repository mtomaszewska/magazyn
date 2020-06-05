package pl.mt.magazyn.services;

import pl.mt.magazyn.models.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService extends BaseService<Order> {
    List<Order> orders(LocalDate date);
}
