package io.mostafaeldahshan.simon_and_kucher.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private LocalDateTime lastUpdate;

    @Column
    private String name;

    @OneToMany(mappedBy = "categoryProduct")
    private Set<Product> categoryProductProducts;

}
