package pl.mt.magazyn.dto;

import org.junit.jupiter.api.Test;
import pl.mt.magazyn.models.OrderElement;
import pl.mt.magazyn.models.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderElementDtoTest {

    @Test
    void from() {
        //given
        OrderElement orderElement = new OrderElement();
        orderElement.setId(12L);
        orderElement.setQuantity(BigDecimal.valueOf(12.00));
        Product product = new Product();
        product.setId(13L);
        orderElement.setProduct(product);
        //when
        OrderElementDto orderElementDto = new OrderElementDto().from(orderElement);
        //then
        assertEquals(orderElement.getId(), orderElementDto.getId());
        assertEquals(orderElement.getQuantity(), orderElementDto.getQuantity());
        assertEquals(orderElement.getProduct().getId(), orderElementDto.getProduct().getId());
    }

    @Test
    void to() {
        //given
        OrderElementDto orderElementDto = new OrderElementDto();
        orderElementDto.setId(12L);
        orderElementDto.setQuantity(BigDecimal.valueOf(12.00));
        ProductDto productDto = new ProductDto();
        productDto.setId(13L);
        orderElementDto.setProduct(productDto);
        //when
        OrderElement orderElement = orderElementDto.to();
        //then
        assertEquals(orderElementDto.getId(), orderElement.getId());
        assertEquals(orderElementDto.getQuantity(), orderElement.getQuantity());
        assertEquals(orderElementDto.getProduct().getId(), orderElement.getProduct().getId());
    }
}