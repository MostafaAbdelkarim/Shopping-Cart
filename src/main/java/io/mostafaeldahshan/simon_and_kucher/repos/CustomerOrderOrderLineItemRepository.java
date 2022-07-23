package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.model.CustomerOrderOrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerOrderOrderLineItemRepository extends JpaRepository<CustomerOrderOrderLineItem, Integer> {
}
