package com.alumni.alumnidirectory.repository;

import com.alumni.alumnidirectory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}