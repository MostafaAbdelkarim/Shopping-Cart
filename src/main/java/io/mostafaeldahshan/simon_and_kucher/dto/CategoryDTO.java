package io.mostafaeldahshan.simon_and_kucher.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private LocalDateTime lastUpdate;
    @Size(max = 255)
    private String name;

}
