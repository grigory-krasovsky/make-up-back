package com.example.makeupback.db.palette;

import com.example.makeupback.db.brand.BrandDto;
import com.example.makeupback.db.tag.TagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class PaletteDto {

    private String name;
    private BigDecimal price;
    private String description;
    private Integer rating;
    private List<TagDto> tags;
    private BrandDto brandDto;

    public static PaletteDto from(Palette palette) {
        return PaletteDto.builder()
                .name(palette.getName())
                .price(palette.getPrice())
                .description(palette.getDescription())
                .rating(palette.getRating())
                .tags(palette.getTags().stream().map(TagDto::from).toList())
                .brandDto(BrandDto.from(palette.getBrand()))
                .build();
    }
}
