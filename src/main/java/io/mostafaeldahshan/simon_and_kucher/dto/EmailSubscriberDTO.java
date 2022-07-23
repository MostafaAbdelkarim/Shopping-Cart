package io.mostafaeldahshan.simon_and_kucher.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class EmailSubscriberDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
