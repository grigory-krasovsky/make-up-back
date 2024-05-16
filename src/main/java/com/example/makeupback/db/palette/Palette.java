package com.example.makeupback.db.palette;

import com.example.makeupback.db.brand.Brand;
import com.example.makeupback.db.tag.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "palettes")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Palette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private Integer rating;
    private String description;
    private String image;

    @ManyToOne
    private Brand brand;

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(
            name = "palette_tag",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "t_id"))
    private List<Tag> tags;

    public Palette updateBy(Palette source) {
//        this.brand = source.getBrand();
        this.image = source.getImage();
        this.name = source.getName();
        this.price = source.getPrice();
        this.rating = source.getRating();
        this.description = source.getDescription();
        return this;
    }
}
