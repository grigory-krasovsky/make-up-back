package com.example.makeupback.controller.palette;

import com.example.makeupback.db.palette.PaletteDto;
import com.example.makeupback.service.palette.PaletteService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/palettes")
@AllArgsConstructor
public class PaletteController {

    PaletteService paletteService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PaletteDto getById(@PathVariable Long id) {
        return PaletteDto.from(paletteService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaletteDto> getAll() {
        return paletteService.findAll().stream().map(PaletteDto::from).toList();
    }
}
