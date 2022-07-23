package io.mostafaeldahshan.simon_and_kucher.controller;

import io.mostafaeldahshan.simon_and_kucher.dto.AdminDTO;
import io.mostafaeldahshan.simon_and_kucher.service.AdminService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping()
    @ApiResponse(responseCode = "200")
    public ResponseEntity adminSignUp(@RequestBody @Valid final AdminDTO adminDTO){
        return adminService.adminSignUp(adminDTO);
    }

    @PostMapping()
    @ApiResponse(responseCode = "200")
    public ResponseEntity adminLogin(@RequestBody @Valid final AdminDTO adminDTO){
        return adminService.adminLogin(adminDTO);
    }
}
