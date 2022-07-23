package io.mostafaeldahshan.simon_and_kucher.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, name = "\"description\"")
    private String description;

    @Column
    private byte[] image;

    @Column
    private LocalDateTime lastUpdate;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_product_id", nullable = false)
    private Category categoryProduct;

    @OneToOne
    @JoinColumn(name = "product_order_item_id", nullable = false)
    private OrderLineItem productOrderItem;

}
