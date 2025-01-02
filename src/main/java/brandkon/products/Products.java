package brandkon.products;

import brandkon.brands.Brands;
import jakarta.persistence.*;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Brands brands;

    String ProductName;
    Long price;
    String imageUrl;

    public Products(Long id, Brands brands, String productName, Long price, String imageUrl) {
        this.id = id;
        this.brands = brands;
        ProductName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public Brands getBrands() {
        return brands;
    }

    public String getProductName() {
        return ProductName;
    }

    public Long getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
