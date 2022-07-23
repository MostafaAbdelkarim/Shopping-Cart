package io.mostafaeldahshan.simon_and_kucher.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class CartItem {

    private int id;
    private int productId;
    private int quantity;
    private double total;

}
