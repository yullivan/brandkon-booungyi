package brandkon.products;

import brandkon.brands.Brands;
import brandkon.brands.BrandsResponse;

public record ProductsResponse2(Long productId,
                                String productName,
                                Long price,
                                BrandsResponse brand,
                                String expirationDays) {
}
