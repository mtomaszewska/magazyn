package pl.mt.magazyn.dto;

import pl.mt.magazyn.models.Product;

import java.math.BigDecimal;

public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;

    public ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public Product to(){
        Product product = new Product();
        product.setId(this.getId());
        product.setPrice(this.getPrice());
        product.setName(this.getName());
        return product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
