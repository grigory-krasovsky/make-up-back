package com.example.makeupback.controller.palette;

import com.example.makeupback.db.palette.PaletteDto;
import com.example.makeupback.service.palette.PaletteService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/palettes")
@AllArgsConstructor
public class PaletteController {

    PaletteService paletteService;

//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public PaletteDto getById(@PathVariable Long id) {
//        return PaletteDto.from(paletteService.findById(id));
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @SneakyThrows
    public List<PaletteDto> getAll() {
        return paletteService.findAll().stream().sorted().toList();
    }

    @PutMapping(value = "/{id}")
    public void updatePalette(@PathVariable Long id, @RequestBody PaletteDto dto) {
        paletteService.update(dto, id);
    }

    @PostMapping
    public void createPalette(@RequestBody PaletteDto dto) {
        paletteService.create(dto);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePalette(@PathVariable Long id) {
        paletteService.delete(id);
    }

}
