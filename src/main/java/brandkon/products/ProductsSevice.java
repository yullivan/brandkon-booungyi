package brandkon.products;

import brandkon.brands.Brands;
import brandkon.brands.BrandsRepository;
import brandkon.brands.BrandsResponse;
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

    public List<ProductsResponse> getproducts() {
        return productsRepository.findAll().stream()
                .map(products -> new ProductsResponse(
                        products.getId(),
                        products.getBrand().getName(),
                        products.getName(),
                        products.getPrice(),
                        products.getImageUrl()
                )).toList();
    }

    public List<ProductsResponse> getproductsBrandId(Long brandId) {
        if (brandId == null) {
            return productsRepository.findAll().stream()
                    .map(products -> new ProductsResponse(
                            products.getId(),
                            products.getBrand().getName(),
                            products.getName(),
                            products.getPrice(),
                            products.getImageUrl()
                    )).toList();
        }
        Brands brands = brandsRepository.findById(brandId).orElseThrow();
        return productsRepository.findById(brands.getId()).stream()
                .map(products -> new ProductsResponse(
                        products.getId(),
                        products.getBrand().getName(),
                        products.getName(),
                        products.getPrice(),
                        products.getImageUrl())).toList();
    }

    public ProductsResponse2 getproductid(Long productId) {
        Brands brand = brandsRepository.findById(productId).orElseThrow();
        BrandsResponse brands = new BrandsResponse(brand.getId(), brand.getName(), brand.getImageUrl());
        Product product = productsRepository.findById(productId).orElseThrow();
        return new ProductsResponse2(
                product.getId(),
                product.getName(),
                product.getPrice(),
                brands,
                product.getExpirationDays());
    }
}
