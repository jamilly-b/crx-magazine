package com.crx.Magazine.Models.Repository;

import com.crx.Magazine.Models.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNome(String nome);
    Optional<User> findByEmail(String email);


}
