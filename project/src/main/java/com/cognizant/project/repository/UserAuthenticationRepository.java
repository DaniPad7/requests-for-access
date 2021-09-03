package com.cognizant.project.repository;

import com.cognizant.project.model.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Long> {
    UserAuthentication findByUsername(String username);
}
