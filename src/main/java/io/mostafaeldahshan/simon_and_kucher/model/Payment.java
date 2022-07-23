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
public class Payment {

    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private Double amount;

    @Column
    private LocalDateTime paymentDate;

    @Column
    private String paymentStatus;

    @Column
    private String transactionId;

    @Column
    private Long customerOrderId;

    @Column
    private Long customerId;

    @OneToOne(mappedBy = "orderPayment", fetch = FetchType.LAZY)
    private CustomerOrder orderPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_customer_id", nullable = false)
    private Customer paymentCustomer;

}
