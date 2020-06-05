package pl.mt.magazyn.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "order_date")
    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderElement> orderElements;
    @ManyToOne
    Client client;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<OrderElement> getOrderElements() {
        return orderElements;
    }

    public void setOrderElements(Set<OrderElement> orderElements) {
        this.orderElements = orderElements;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
