package com.example.makeupback.service.brand;

import com.example.makeupback.db.brand.BrandDto;
import com.example.makeupback.db.brand.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {

    private BrandRepository brandRepository;

    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map(BrandDto::from).toList();
    }
}
