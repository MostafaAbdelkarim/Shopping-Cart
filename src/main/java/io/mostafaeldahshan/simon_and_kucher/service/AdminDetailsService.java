package io.mostafaeldahshan.simon_and_kucher.service;

import io.mostafaeldahshan.simon_and_kucher.model.Admin;
import io.mostafaeldahshan.simon_and_kucher.model.AdminRoles;
import io.mostafaeldahshan.simon_and_kucher.repos.AdminRepository;
import io.mostafaeldahshan.simon_and_kucher.repos.AdminRolesRepository;
import io.mostafaeldahshan.simon_and_kucher.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminRolesRepository adminRolesRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.getUserByUsername(username);
        AdminRoles adminRoles = new AdminRoles();
        if (admin == null) {
            throw new UsernameNotFoundException("Could not find admin");
        }
        return new MyUserDetails(adminRoles, admin);
    }
}
