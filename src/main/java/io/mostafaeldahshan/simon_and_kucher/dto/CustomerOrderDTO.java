package io.mostafaeldahshan.simon_and_kucher.dto;

import io.mostafaeldahshan.simon_and_kucher.model.Customer;
import io.mostafaeldahshan.simon_and_kucher.model.CustomerOrderOrderLineItem;
import io.mostafaeldahshan.simon_and_kucher.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDTO {

    private Long id;
    private LocalDateTime orderDate;
    private String orderStatus;
    private Double orderAmount;
    private Long customerId;
    private Set<CustomerOrderOrderLineItem> customerOrderPerItemCustomerOrderOrderLineItems;
    private Payment orderPayment;
    private Set<Customer> customerOrderCustomers;

}
