package io.mostafaeldahshan.simon_and_kucher.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaymentDTO {

    private Long id;

    private Double amount;

    private LocalDateTime paymentDate;

    @Size(max = 255)
    private String paymentStatus;

    @Size(max = 255)
    private String transactionId;

    private UUID customerOrderId;

    private UUID customerId;

    @NotNull
    private UUID paymentCustomer;

}
