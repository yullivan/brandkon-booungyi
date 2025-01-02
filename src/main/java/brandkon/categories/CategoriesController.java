package brandkon.categories;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    //Todo 카테고리목록 조회
    @GetMapping("/categories")
    public List<Categories> categoriesList() {
        return categoriesService.getcategories();
    }
}

