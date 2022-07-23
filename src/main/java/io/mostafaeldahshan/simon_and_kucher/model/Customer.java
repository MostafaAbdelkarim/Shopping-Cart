package io.mostafaeldahshan.simon_and_kucher.model;

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
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String street;

    @OneToMany(mappedBy = "paymentCustomer")
    private Set<Payment> paymentCustomerPayments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_order_id", nullable = false)
    private CustomerOrder customerOrder;

}
