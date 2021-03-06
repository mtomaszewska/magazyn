package pl.mt.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mt.magazyn.dto.ProductDto;
import pl.mt.magazyn.services.ProductService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    Set<ProductDto> products(){
        return productService.all().stream()
                .map(product -> new ProductDto().from(product)).collect(Collectors.toSet());
    }
}
