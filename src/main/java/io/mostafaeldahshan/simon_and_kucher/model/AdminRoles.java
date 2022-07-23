package io.mostafaeldahshan.simon_and_kucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AdminRoles {

    @Id
    @Column(nullable = false, updatable = false, length = 15)
    private String userName;

    @Column(length = 15)
    private String roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_role_id", nullable = false)
    private Admin adminRole;

}
