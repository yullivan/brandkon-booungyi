package brandkon.categories;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    public List<Categories> getcategories() {
        return categoriesRepository.findAll()
                .stream()
                .map(categories ->
                        new Categories(
                                categories.getId(),
                                categories.getName(),
                                categories.getSlug(),
                                categories.getImageUrl()))
                .toList();
    }
}
