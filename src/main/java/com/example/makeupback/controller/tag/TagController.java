package com.example.makeupback.controller.tag;

import com.example.makeupback.db.tag.TagDto;
import com.example.makeupback.service.tag.TagService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public List<TagDto> getAll() {
        return tagService.getAllTags();
    }
}
