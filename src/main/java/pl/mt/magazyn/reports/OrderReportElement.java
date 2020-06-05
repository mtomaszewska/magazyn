package pl.mt.magazyn.reports;

import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.models.Product;

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
        for(Product product : order.getProducts()){
            cost = cost.add(product.getPrice());
        }
        return cost;
    }
}
