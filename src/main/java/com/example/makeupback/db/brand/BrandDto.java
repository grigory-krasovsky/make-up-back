package com.example.makeupback.db.brand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class BrandDto {
    private String title;
    private Long id;

    public static BrandDto from(Brand brand) {
        return BrandDto.builder()
                .title(brand.getTitle())
                .id(builder().id)
                .build();
    }
}
