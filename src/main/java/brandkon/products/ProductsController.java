package brandkon.products;

import brandkon.brands.Brands;
import brandkon.brands.BrandsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductsController {
    ProductsSevice productsSevice;

    public ProductsController(ProductsSevice productsSevice) {

        this.productsSevice = productsSevice;
    }

    @GetMapping("/products")
    public List<ProductsResoponse> productsList() {
        return productsSevice.getproducts();
    }

//    @GetMapping("/products")
//    public List<Products> getproductsid(@Valid @RequestParam Long brandsId) {
//        return productsSevice.getproductsBrandId(brandsId);
//
//    }
}
