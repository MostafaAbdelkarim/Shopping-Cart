package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.model.CustomerOrder;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, UUID> {
}
