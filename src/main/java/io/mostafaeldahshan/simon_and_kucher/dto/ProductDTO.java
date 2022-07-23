package io.mostafaeldahshan.simon_and_kucher.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String code;

    @NotNull
    @Size(max = 255)
    private String description;

    @Size(max = 255)
    private byte[] image;

    private LocalDateTime lastUpdate;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long categoryProduct;

    @NotNull
    private Long productOrderItem;

}
