package pl.mt.magazyn.dto;

import org.junit.jupiter.api.Test;
import pl.mt.magazyn.models.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDtoTest {

    @Test
    void from() {
        //given
        Product product = new Product();
        product.setId(12L);
        product.setName("NAME");
        product.setPrice(BigDecimal.valueOf(10.00));
        //when
        ProductDto productDto = new ProductDto().from(product);
        //then
        assertEquals(product.getId(), productDto.getId());
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getPrice(), productDto.getPrice());

    }
}