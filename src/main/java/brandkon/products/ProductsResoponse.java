package brandkon.products;

public record ProductsResoponse(
        Long id,
        String brandName,
        String productName,
        Long price,
        String imageUrl
) {
}
