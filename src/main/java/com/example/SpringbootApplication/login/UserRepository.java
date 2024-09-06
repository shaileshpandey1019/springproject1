package com.example.SpringbootApplication.login;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

// UserRepository should be an interface, not a class
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
