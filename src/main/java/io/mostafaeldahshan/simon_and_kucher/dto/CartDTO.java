package io.mostafaeldahshan.simon_and_kucher.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {

    private Long id;
    private List<CartItem> cartItems;
    private double cartTotal;
}
