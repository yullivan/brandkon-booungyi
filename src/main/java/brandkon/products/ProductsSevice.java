package brandkon.products;

import brandkon.brands.Brands;
import brandkon.brands.BrandsRepository;
import brandkon.brands.BrandsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductsSevice {
    ProductsRepository productsRepository;
    BrandsRepository brandsRepository;

    public ProductsSevice(ProductsRepository productsRepository, BrandsRepository brandsRepository) {
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
        Product product = productsRepository.findById(productId).orElseThrow();
        Brands brand = brandsRepository.findById(product.getId()).orElseThrow();
        BrandsResponse brands = new BrandsResponse(brand.getId(), brand.getName(), brand.getImageUrl());
        return new ProductsResponse2(
                product.getId(),
                product.getName(),
                product.getPrice(),
                brands,
                product.getExpirationDays());
    }

    public List<ProductsResponse3> getpopularproduct(Long categoryId, Long brandId) {
        if (categoryId != null && brandId == null) {
            return productsRepository.findById(categoryId)
                    .stream()
                    .map(product1 -> new ProductsResponse3(
                                    product1.getId(),
                                    product1.getBrand().getName(),
                                    product1.getName(),
                                    product1.getPrice(),
                                    product1.getImageUrl()
                            )
                    ).limit(5).toList();
        }
        //brandId 가 들어오게되면
        if (categoryId == null && brandId != null) {
            Brands brands = brandsRepository.findById(brandId).orElseThrow();
            return productsRepository.findById(brandId).stream().map(
                    product -> new ProductsResponse3(product.getId(),
                            product.getBrand().getName(),
                            product.getName(),
                            product.getPrice(),
                            product.getImageUrl())
            ).limit(5).toList();
        }

        //categoryId 가 잇을 떄 , 브랜드 필터가 없으면 categorId로. 필터링
        return null;
    }
}