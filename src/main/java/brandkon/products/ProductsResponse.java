package brandkon.products;

public record ProductsResponse(
        Long id,
        String brandName,
        String productName,
        Long price,
        String imageUrl
) {
}
