package com.example.makeupback.service.palette;

import com.example.makeupback.db.palette.Palette;
import com.example.makeupback.db.palette.PaletteDto;
import com.example.makeupback.db.palette.PaletteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
@AllArgsConstructor
public class PaletteService {
    private final PaletteRepository paletteRepository;

//    public Palette findById(Long id) {
//        return paletteRepository.findById(id).orElse(null);
//    }

    public List<Palette> findAll() {
        return paletteRepository.findAll();
    }

    public void create(PaletteDto dto) {
        createOrUpdate(dto.to());
    }

    public void update(PaletteDto dto, Long id) {
        Palette p = paletteRepository.findById(id).orElseThrow(() -> new InvalidParameterException(String.format("Palette with id %s does not exist", id)));
        p.updateBy(dto.to());
        createOrUpdate(p);
    }

    public void delete(Long id) {
        paletteRepository.deleteById(id);
    }

    private void createOrUpdate(Palette p) {
        paletteRepository.save(p);
    }
}
