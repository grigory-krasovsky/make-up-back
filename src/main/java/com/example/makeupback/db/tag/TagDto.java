package com.example.makeupback.db.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class TagDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;

    public static TagDto from(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .title(tag.getTitle())
                .build();
    }

    public static Tag to(TagDto dto) {
        return Tag.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .build();
    }
}
