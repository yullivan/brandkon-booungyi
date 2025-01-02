package brandkon.brands;

import brandkon.categories.Categories;
import jakarta.persistence.*;

@Entity
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageUrl; // image)
    @ManyToOne
    private Categories category;

    private String guidelines;

    public Brands() {
    }

    public Brands(Long id, String name, String image_Url, Categories category, String guidelines) {
        this.id = id;
        this.name = name;
        this.imageUrl = image_Url;
        this.category = category;
        this.guidelines = guidelines;
    }

    public Brands(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Categories getCategory() {
        return category;
    }

    public String getGuidelines() {
        return guidelines;
    }
}
