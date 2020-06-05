package pl.mt.magazyn.reports;

import org.springframework.context.annotation.Primary;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.models.OrderElement;
import pl.mt.magazyn.models.Product;

import java.math.BigDecimal;

public class ProductReportElement implements ReportElement {
    private Product product;
    private BigDecimal quantity;

    public ProductReportElement(Product product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String report(){
        return product.getName() + " " + quantity + " " + cost();
    }

    private BigDecimal cost(){
        return this.quantity.multiply(this.product.getPrice());
    }
}
