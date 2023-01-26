package pl.migibud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType productType;

    @OneToMany(mappedBy = "product",orphanRemoval = true)
    private Set<Review> reviews;

    enum ProductType {
        REAL, VIRTUAL
    }

}
