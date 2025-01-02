package brandkon.categories;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    public List<CategoriesResponse> getcategories() {
        return categoriesRepository.findAll()
                .stream()
                .map(categories ->
                        new CategoriesResponse(
                                categories.getId(),
                                categories.getName(),
                                categories.getSlug(),
                                categories.getImageUrl()))
                .toList();
    }
}
