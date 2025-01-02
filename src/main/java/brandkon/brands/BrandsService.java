package brandkon.brands;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandsService {
    BrandsRepository brandsRepository;

    public BrandsService(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    public List<Brands> getbrands() {
        return brandsRepository.findAll()
                .stream()
                .map(brands ->
                        new Brands(brands.getId(),
                                brands.getName(),
                                brands.getImageUrl()
                        )).toList();
    }
}
