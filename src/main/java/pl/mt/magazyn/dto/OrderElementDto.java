package pl.mt.magazyn.dto;

import pl.mt.magazyn.models.OrderElement;

import java.math.BigDecimal;

public class OrderElementDto {
    private Long id;
    private ProductDto product;
    private BigDecimal quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public OrderElementDto from(OrderElement element) {
        this.setId(element.getId());
        this.setQuantity(element.getQuantity());
        this.setProduct(new ProductDto().from(element.getProduct()));
        return this;
    }

    public OrderElement to() {
        OrderElement orderElement = new OrderElement();
        orderElement.setId(this.getId());
        orderElement.setQuantity(this.getQuantity());
        orderElement.setProduct(this.getProduct().to());
        return orderElement;
    }
}
