package io.mostafaeldahshan.simon_and_kucher.controller;

import io.mostafaeldahshan.simon_and_kucher.dto.EmailSubscriberDTO;
import io.mostafaeldahshan.simon_and_kucher.service.EmailService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/emails", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/subscribe")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<Void> subscribeToEmailList(@RequestBody final EmailSubscriberDTO subscriber){
        emailService.subscribe(subscriber);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/showall")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<List<EmailSubscriberDTO>> getMailList(){
        emailService.getMailList();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/downloadEmailList")
    @ApiResponse(responseCode = "200")
    public void downloadEmailList(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "filename=\"EmailList.csv\"");
        emailService.downloadEmailList(servletResponse.getWriter());
    }

}
