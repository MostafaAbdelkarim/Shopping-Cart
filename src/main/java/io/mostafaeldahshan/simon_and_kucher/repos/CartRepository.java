package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
