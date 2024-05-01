package com.example.makeupback.controller.palette;

import com.example.makeupback.db.palette.PaletteDto;
import com.example.makeupback.service.palette.PaletteService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/palettes")
@AllArgsConstructor
public class PaletteController {

    PaletteService paletteService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PaletteDto getById(@PathVariable Long id) {
        return PaletteDto.from(paletteService.findById(id));
    }
}
