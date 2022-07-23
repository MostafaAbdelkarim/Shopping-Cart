package io.mostafaeldahshan.simon_and_kucher.security;

import io.mostafaeldahshan.simon_and_kucher.model.Admin;
import io.mostafaeldahshan.simon_and_kucher.model.AdminRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private AdminRoles adminRoles;
    private Admin admin;

    public MyUserDetails(AdminRoles adminRoles, Admin admin) {
        this.adminRoles = adminRoles;
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(adminRoles.getRoleName());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
