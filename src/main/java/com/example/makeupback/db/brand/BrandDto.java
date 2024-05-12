package com.example.makeupback.db.brand;

import lombok.Builder;

@Builder
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
