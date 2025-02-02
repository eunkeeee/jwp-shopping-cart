package cart.service.product;

import cart.entity.product.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductDeleteService {

    private final ProductDao productDao;

    public ProductDeleteService(final ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public void deleteProductBy(long id) {
        productDao.deleteById(id);
    }
}
