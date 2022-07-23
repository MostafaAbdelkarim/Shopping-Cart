package io.mostafaeldahshan.simon_and_kucher.service;

import io.mostafaeldahshan.simon_and_kucher.dto.AdminDTO;
import io.mostafaeldahshan.simon_and_kucher.model.Admin;
import io.mostafaeldahshan.simon_and_kucher.repos.AdminRepository;
import io.mostafaeldahshan.simon_and_kucher.security.PasswordEncoderConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoderConfig passwordEncoderConfig;

    public AdminService(AdminRepository adminRepository, PasswordEncoderConfig passwordEncoderConfig) {
        this.adminRepository = adminRepository;
        this.passwordEncoderConfig = passwordEncoderConfig;
    }

    public ResponseEntity adminLogin(AdminDTO adminDTO){
        Admin admin = adminRepository.getUserByUsername(adminDTO.getUserName());
        if(admin == null){
            throw new RuntimeException();
        }
        if(!passwordEncoderConfig.bCryptPasswordEncoder().matches(adminDTO.getPassword(), admin.getPassword())){
            throw new RuntimeException("Password mismatch");
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity adminSignUp(AdminDTO adminDTO){
        Admin admin = new Admin();
        admin.setUserName(adminDTO.getUserName());
        String encodedPassword = passwordEncoderConfig.bCryptPasswordEncoder().encode(adminDTO.getPassword());
        admin.setPassword(encodedPassword);
        adminRepository.save(admin);
        return new ResponseEntity(HttpStatus.OK);
    }
}
