package com.example.makeupback.service.palette;

import com.example.makeupback.db.palette.Palette;
import com.example.makeupback.db.palette.PaletteDto;
import com.example.makeupback.db.palette.PaletteRepository;
import com.example.makeupback.db.tag.Tag;
import com.example.makeupback.db.tag.TagDto;
import com.example.makeupback.service.brand.BrandService;
import com.example.makeupback.service.tag.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
@AllArgsConstructor
public class PaletteService {
    private final PaletteRepository paletteRepository;
    private final TagService tagService;
    private final BrandService brandService;

//    public Palette findById(Long id) {
//        return paletteRepository.findById(id).orElse(null);
//    }

    public List<PaletteDto> findAll() {
        return paletteRepository.findAll().stream().map(PaletteDto::from).toList();
    }

    public void create(PaletteDto dto) {
        createOrUpdate(dto.to());
    }

    public void update(PaletteDto dto, Long id) {
        Palette p = paletteRepository.findById(id).orElseThrow(() -> new InvalidParameterException(String.format("Palette with id %s does not exist", id)));

        Palette source = dto.to();
        source.setTags(tagService.getAllTagsByIdIn(dto.getTags().stream().map(TagDto::getId).toList()));
        source.setBrand(brandService.getBrandById(id));

        p.updateBy(dto.to());
        createOrUpdate(p);
    }

    public void delete(Long id) {
        paletteRepository.deleteById(id);
    }

    private void createOrUpdate(Palette p) {
        try {
            paletteRepository.save(p);
        } catch (UnsupportedOperationException u) {
            paletteRepository.save(p);
        }
    }
}
