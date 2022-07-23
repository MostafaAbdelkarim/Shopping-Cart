package io.mostafaeldahshan.simon_and_kucher.service;

import io.mostafaeldahshan.simon_and_kucher.dto.EmailSubscriberDTO;
import io.mostafaeldahshan.simon_and_kucher.model.EmailSubscriber;
import io.mostafaeldahshan.simon_and_kucher.repos.EmailSubscriberRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmailService {

    private final EmailSubscriberRepository emailSubscriberRepository;

    public EmailService(EmailSubscriberRepository emailSubscriberRepository) {
        this.emailSubscriberRepository = emailSubscriberRepository;
    }

    public void subscribe(EmailSubscriberDTO emailSubscriberDTO){
        EmailSubscriber emailSubscriber = new EmailSubscriber();
        emailSubscriberRepository.save(mapToEntity(emailSubscriberDTO, emailSubscriber));
    }

    public List<EmailSubscriberDTO> getMailList(){
        return emailSubscriberRepository.findAll(Sort.by("id"))
                .stream()
                .map(email -> mapToDTO(email, new EmailSubscriberDTO()))
                .collect(Collectors.toList());
    }

    public void downloadEmailList(Writer writer){
        List<EmailSubscriber> emailSubscriberDTOS = emailSubscriberRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (EmailSubscriber email : emailSubscriberDTOS) {
                csvPrinter.printRecord(email.getId(), email.getFirstName(), email.getLastName(), email.getEmail());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV {}", e);
        }
    }

    public EmailSubscriber mapToEntity(EmailSubscriberDTO emailSubscriberDTO, EmailSubscriber emailSubscriber){
        emailSubscriber.setId(emailSubscriberDTO.getId());
        emailSubscriber.setEmail(emailSubscriberDTO.getEmail());
        emailSubscriber.setFirstName(emailSubscriberDTO.getFirstName());
        emailSubscriber.setLastName(emailSubscriberDTO.getLastName());
        return emailSubscriber;
    }

    public EmailSubscriberDTO mapToDTO(EmailSubscriber emailSubscriber, EmailSubscriberDTO emailSubscriberDTO){
        emailSubscriberDTO.setId(emailSubscriber.getId());
        emailSubscriberDTO.setEmail(emailSubscriber.getEmail());
        emailSubscriberDTO.setFirstName(emailSubscriber.getFirstName());
        emailSubscriberDTO.setLastName(emailSubscriber.getLastName());
        return emailSubscriberDTO;
    }
}
