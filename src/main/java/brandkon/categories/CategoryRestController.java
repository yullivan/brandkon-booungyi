package brandkon.categories;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRestController {

    CategoriesService categoriesService;

    public CategoryRestController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    //Todo 카테고리목록 조회
    @GetMapping("/categories")
    public List<CategoriesResponse> getAll() {
        return categoriesService.getcategories();
    }
}

