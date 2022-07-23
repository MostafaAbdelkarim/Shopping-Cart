package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AdminRepository extends JpaRepository<Admin, String> {

    @Query("SELECT u FROM \'admin\' u WHERE u.username = :username")
    public Admin getUserByUsername(@Param("username") String username);

}
