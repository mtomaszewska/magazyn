package pl.mt.magazyn.services.implementations;

import org.springframework.stereotype.Service;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.repositories.BaseEntityRepository;
import pl.mt.magazyn.services.OrderService;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    public OrderServiceImpl(BaseEntityRepository<Order> repository) {
        super(repository);
    }

    public Order save(Order e) {
        if(e != null && e.getClient() != null){
            return super.save(e);
        }else if(e == null){
            throw new IllegalArgumentException("order cannot be null");
        }else{
            throw new IllegalArgumentException("client property cannot be null");
        }
    }
}
