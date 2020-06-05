package pl.mt.magazyn.services.implementations;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.repositories.BaseEntityRepository;
import pl.mt.magazyn.repositories.OrderRepository;

class OrderServiceImplTest extends BaseServiceImplTest<Order> {

    @InjectMocks
    OrderServiceImpl orderServiceImpl;

    @Mock
    OrderRepository orderRepository;

    @Override
    Order create() {
        Order order = new Order();
        order.setClient(new Client());
        return order;
    }

    @Override
    OrderServiceImpl service() {
        return orderServiceImpl;
    }

    @Override
    OrderRepository repository() {
        return orderRepository;
    }
}