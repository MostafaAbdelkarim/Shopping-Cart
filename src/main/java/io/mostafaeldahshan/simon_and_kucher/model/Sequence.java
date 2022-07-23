package io.mostafaeldahshan.simon_and_kucher.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Sequence {

    @Id
    @Column(nullable = false, updatable = false)
    private String seqName;

    @Column(precision = 38, scale = 2)
    private BigDecimal seqCount;

}
