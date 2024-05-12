package com.example.makeupback.db.tag;

import lombok.Builder;

@Builder
public class TagDto {
    private Long id;
    private String title;

    public static TagDto from(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .title(tag.getTitle())
                .build();
    }
}
