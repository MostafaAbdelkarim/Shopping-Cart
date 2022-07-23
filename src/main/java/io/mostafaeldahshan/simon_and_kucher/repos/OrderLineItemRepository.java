package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.model.OrderLineItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {
}
