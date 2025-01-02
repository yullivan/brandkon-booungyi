package brandkon.products;

import brandkon.brands.Brands;
import brandkon.brands.BrandsRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsSevice {
    ProductsRepository productsRepository;
    BrandsRepository brandsRepository;

    public ProductsSevice(ProductsRepository productsRepository , BrandsRepository brandsRepository) {
        this.productsRepository = productsRepository;
        this.brandsRepository = brandsRepository;
    }

    public List<ProductsResoponse> getproducts() {
        return productsRepository.findAll().stream()
                .map(products -> new ProductsResoponse(
                        products.getId(), products.getBrands().getName(),
                        products.getProductName(), products.getPrice(),
                        products.getImageUrl()
                )).toList();

    }

//    public List<Products> getproductsBrandId(@Valid Long brandsId) {
//        Brands brands = brandsRepository.findAllById(brandsId)
//        return null;
//    }
}
