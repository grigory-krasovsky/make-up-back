package com.example.makeupback.service.tag;

import com.example.makeupback.db.tag.Tag;
import com.example.makeupback.db.tag.TagDto;
import com.example.makeupback.db.tag.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public List<TagDto> getAllTags() {
        return tagRepository.findAll().stream().map(TagDto::from).toList();
    }

    public List<Tag> getAllTagsByIdIn(List<Long> ids) {
        return tagRepository.findAllByIdIn(ids);
    }
}
