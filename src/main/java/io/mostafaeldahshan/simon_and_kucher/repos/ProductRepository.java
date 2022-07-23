package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.model.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByCodeIgnoreCase(String code);

}
