package pl.mt.magazyn.services.implementations;

import org.springframework.stereotype.Service;
import pl.mt.magazyn.models.Product;
import pl.mt.magazyn.repositories.BaseEntityRepository;
import pl.mt.magazyn.services.ProductService;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
    public ProductServiceImpl(BaseEntityRepository<Product> repository) {
        super(repository);
    }
}
