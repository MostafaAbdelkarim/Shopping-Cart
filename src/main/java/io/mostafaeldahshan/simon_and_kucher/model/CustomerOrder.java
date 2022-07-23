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
public class CustomerOrder {

    @Id
    @SequenceGenerator(
            name = "customerOrder_sequence",
            sequenceName = "customerOrder_sequence",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customerOrder_sequence")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private LocalDateTime orderDate;

    @Column
    private String orderStatus;

    @Column
    private Double orderAmount;

    @Column
    private Long customerId;

    @OneToMany(mappedBy = "customerOrderPerItem")
    private Set<CustomerOrderOrderLineItem> customerOrderPerItemCustomerOrderOrderLineItems;

    @OneToOne
    @JoinColumn(name = "order_payment_id", nullable = false)
    private Payment orderPayment;

    @OneToMany(mappedBy = "customerOrder")
    private Set<Customer> customerOrderCustomers;

}
