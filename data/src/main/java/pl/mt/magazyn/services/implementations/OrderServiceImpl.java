package pl.mt.magazyn.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.repositories.OrderRepository;
import pl.mt.magazyn.services.OrderService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    protected OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    public Set<Order> all() {
        return repository.findAll();
    }

    public Order save(Order e) {
        if(e != null && e.getClient() != null){
            return repository.save(e);
        }else if(e == null){
            throw new IllegalArgumentException("order cannot be null");
        }else{
            throw new IllegalArgumentException("client property cannot be null");
        }
    }

    @Override
    public List<Order> orders(LocalDate date) {
        return repository.findByDateBetweenOrderByDate(date.atStartOfDay(), date.atTime(LocalTime.MAX));
    }
}
