package brandkon.brands;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandsController {
    BrandsService brandsService;

    public BrandsController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @GetMapping("/brands")
    public List<BrandsResponse> brandsList() {
        return brandsService.getbrands();
    }
}
