package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.dto.EmailSubscriberDTO;
import io.mostafaeldahshan.simon_and_kucher.model.EmailSubscriber;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailSubscriberRepository extends JpaRepository<EmailSubscriber, UUID> {
}
