package io.mostafaeldahshan.simon_and_kucher.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "\"admin\"")
@Getter
@Setter
public class Admin {

    @Id
    @Column(nullable = false, updatable = false, length = 15)
    private String userName;

    @Column(length = 15)
    private String password;

    @OneToMany(mappedBy = "adminRole")
    private Set<AdminRoles> adminRoleAdminRoless;

}
