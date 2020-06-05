package pl.mt.magazyn.reports;

import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.models.OrderElement;

import java.math.BigDecimal;

public class OrderReportElement implements ReportElement {
    private Order order;

    public OrderReportElement(Order order){
        this.order = order;
    }

    public String report(){
           return String.format("%s %s %s %s", order.getDate(),
                order.getClient().getFirstName(), order.getClient().getLastName(), cost());
    }

    private BigDecimal cost(){
        BigDecimal cost = BigDecimal.ZERO;
        for(OrderElement element : order.getOrderElements()){
            cost = cost.add(element.getQuantity().multiply(element.getProduct().getPrice()));
        }
        return cost;
    }
}
