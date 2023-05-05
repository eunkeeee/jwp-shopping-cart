package cart.controller;

import cart.dto.ProductRequest;
import cart.entity.product.Product;
import cart.service.product.ProductCreateService;
import cart.service.product.ProductDeleteService;
import cart.service.product.ProductUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/admin/products")
public class ProductsController {

    private final ProductCreateService createService;
    private final ProductUpdateService updateService;
    private final ProductDeleteService deleteService;

    public ProductsController(
            final ProductCreateService createService,
            final ProductUpdateService updateService,
            final ProductDeleteService deleteService) {
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        Product product = new Product(productRequest.getName(), productRequest.getImgUrl(), productRequest.getPrice());
        Product createdProduct = createService.createProduct(product);
        final URI location = URI.create("/" + createdProduct.getId());
        return ResponseEntity.created(location).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @Valid @RequestBody ProductRequest productRequest) {
        Product product = new Product(id, productRequest.getName(), productRequest.getImgUrl(), productRequest.getPrice());
        updateService.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        deleteService.deleteProductBy(id);
        return ResponseEntity.noContent().build();
    }
}
