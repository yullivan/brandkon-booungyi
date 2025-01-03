package brandkon.brands;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandsService {
    BrandsRepository brandsRepository;

    public BrandsService(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    public List<BrandsResponse> getbrands() {
        return brandsRepository.findAll()
                .stream()
                .map(brands ->
                        new BrandsResponse(brands.getId(),
                                brands.getName(),
                                brands.getImageUrl()
                        )).toList();
    }

    public BrandsResponse getbrandid(Long brandId) {
        Brands brands = brandsRepository.findById(brandId).orElseThrow();
        return new BrandsResponse(brands.getId(),
                brands.getName(), brands.getImageUrl());
    }
}
