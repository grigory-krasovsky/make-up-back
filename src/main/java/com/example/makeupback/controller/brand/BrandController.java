package com.example.makeupback.controller.brand;

import com.example.makeupback.db.brand.BrandDto;
import com.example.makeupback.service.brand.BrandService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    BrandService brandService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @SneakyThrows
    public List<BrandDto> getAll() {
        return brandService.getAllBrands();
    }
}
