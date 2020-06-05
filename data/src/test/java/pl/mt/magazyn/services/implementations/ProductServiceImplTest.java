package pl.mt.magazyn.services.implementations;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.mt.magazyn.models.Product;
import pl.mt.magazyn.repositories.ProductRepository;

class ProductServiceImplTest extends BaseServiceImplTest<Product> {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Override
    Product create() {
        return new Product();
    }

    @Override
    ProductServiceImpl service() {
        return productService;
    }

    @Override
    ProductRepository repository() {
        return productRepository;
    }
}