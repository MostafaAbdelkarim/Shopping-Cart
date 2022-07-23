package io.mostafaeldahshan.simon_and_kucher.model;

import java.util.UUID;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Getter
@Setter
public class OrderLineItem {

    @Id
    @SequenceGenerator(
            name = "orderLineItem_sequence",
            sequenceName = "orderLineItem_sequence",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderLineItem_sequence")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private Integer quantity;

    @Column
    private Long productId;

    @OneToOne(
            mappedBy = "productOrderItem",
            fetch = FetchType.LAZY
    )
    private Product productOrderItem;

    @OneToOne
    @JoinColumn(name = "quantity_item_id")
    private CustomerOrderOrderLineItem quantityItem;

}
