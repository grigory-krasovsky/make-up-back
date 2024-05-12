package com.example.makeupback.db.tag;

import com.example.makeupback.db.palette.Palette;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tags")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "tags")
    private List<Palette> palettes;
}
