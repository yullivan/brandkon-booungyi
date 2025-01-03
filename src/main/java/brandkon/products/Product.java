package brandkon.products;

import brandkon.brands.Brands;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private String expirationDays;
    // brands_id
    private String imageUrl;

    @ManyToOne
    private Brands brand;


    public Product() {

    }

    public Product(Long id, String name, Brands brand, Long price, String expirationDays, String imageUrl) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.expirationDays = expirationDays;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Brands getBrand() {
        return brand;
    }

    public Long getPrice() {
        return price;
    }

    public String getExpirationDays() {
        return expirationDays;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
