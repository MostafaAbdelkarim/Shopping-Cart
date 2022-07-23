package io.mostafaeldahshan.simon_and_kucher.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AdminDTO {

    @NotNull
    private String userName;
    @NotNull
    private String password;

}
