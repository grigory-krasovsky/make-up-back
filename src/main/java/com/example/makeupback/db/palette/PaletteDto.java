package com.example.makeupback.db.palette;

import com.example.makeupback.db.brand.BrandDto;
import com.example.makeupback.db.tag.TagDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class PaletteDto {


    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("description")
    private String description;

    private String image;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("tags")
    private List<TagDto> tags;

    @JsonProperty("brand")
    private BrandDto brand;


    public static PaletteDto from(Palette palette) {
        return PaletteDto.builder()
                .id(palette.getId())
                .name(palette.getName())
                .image(palette.getImage())
                .price(palette.getPrice())
                .description(palette.getDescription())
                .rating(palette.getRating())
                .tags(palette.getTags().stream().map(TagDto::from).toList())
                .brand(BrandDto.from(palette.getBrand()))
                .build();
    }

    public Palette to() {
        return Palette.builder()
                .id(this.getId())
                .image(this.getImage())
                .name(this.getName())
                .price(this.getPrice())
                .description(this.getDescription())
                .rating(this.getRating())
                .tags(this.getTags().stream().map(TagDto::to).toList())
                .brand(BrandDto.to(this.getBrand()))
                .build();
    }
}
