package com.example.makeupback.db.palette;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class PaletteDto {

    private String name;
    private BigDecimal price;
    private String description;
    private Integer rating;

    public static PaletteDto from(Palette palette) {
        return new PaletteDto(palette.getName(), palette.getPrice(), palette.getDescription(), palette.getRating());
    }
}
