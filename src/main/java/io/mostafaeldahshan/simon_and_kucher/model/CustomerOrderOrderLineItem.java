package io.mostafaeldahshan.simon_and_kucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class CustomerOrderOrderLineItem {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerOrderId;

    @Column
    private Long lineItemsId;

    @OneToOne(mappedBy = "quantityItem", fetch = FetchType.LAZY)
    private OrderLineItem quantityItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_order_per_item_id")
    private CustomerOrder customerOrderPerItem;

}
