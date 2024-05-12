package com.example.makeupback.service.palette;

import com.example.makeupback.db.palette.Palette;
import com.example.makeupback.db.palette.PaletteDto;
import com.example.makeupback.db.palette.PaletteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaletteService {
    private final PaletteRepository paletteRepository;

    public Palette findById(Long id) {
        return paletteRepository.findById(id).orElse(null);
    }

    public List<Palette> findAll() {
        return paletteRepository.findAll();
    }

//    public Palette create(PaletteDto dto) {
//
//    }
}
