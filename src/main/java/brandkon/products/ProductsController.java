package brandkon.products;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductsController {
    ProductsSevice productsSevice;

    public ProductsController(ProductsSevice productsSevice) {
        this.productsSevice = productsSevice;
    }

//    @GetMapping("/products")
//    public List<ProductsResoponse> productsList() {
//        return productsSevice.getproducts();
//    }

    @GetMapping("/products")
    public List<ProductsResponse> getproductsid(@Valid @RequestParam(required = false) Long brandId) {
        return productsSevice.getproductsBrandId(brandId);

    }

    @GetMapping("/products/{productId}")
    public ProductsResponse2 getproductId(@PathVariable Long productId) {
        return productsSevice.getproductid(productId);
    }
}