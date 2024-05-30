package com.example.makeupback.db.brand;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class BrandDto {
    @JsonProperty("title")
    private String title;
    @JsonProperty("id")
    private Long id;

    public static BrandDto from(Brand brand) {
        return BrandDto.builder()
                .title(brand.getTitle())

                .id(brand.getId())
                .build();
    }

    public static Brand to(BrandDto dto) {
        return Brand.builder()
                .title(dto.getTitle())
                .id(dto.id)
                .build();
    }
}
