package com.example.makeupback.db.palette;

import com.example.makeupback.db.brand.Brand;
import com.example.makeupback.db.tag.Tag;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "palettes")
@Data
public class Palette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private Integer rating;
    private String description;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Brand brand;

    @ManyToMany
    @JoinTable(
            name = "palette_tag",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "t_id"))
    private List<Tag> tags;
}
