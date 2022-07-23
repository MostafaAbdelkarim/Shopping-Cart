package io.mostafaeldahshan.simon_and_kucher.model;

import io.mostafaeldahshan.simon_and_kucher.dto.CartItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Cart {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence")
    @Column(unique = true, nullable = false)
    private Long id;

    @ElementCollection
    @Column(nullable = false)
    private List<CartItem> cartItems;

    @Column(nullable = false)
    private double cartTotal;

}
