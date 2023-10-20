package com.example.security_authantication_autharization_example.repository;

import com.example.security_authantication_autharization_example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String userEmail);
}
