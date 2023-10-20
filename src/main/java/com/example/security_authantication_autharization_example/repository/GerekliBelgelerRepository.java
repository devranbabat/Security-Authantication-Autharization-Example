package com.example.security_authantication_autharization_example.repository;

import com.example.security_authantication_autharization_example.entity.GerekliBelgeler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerekliBelgelerRepository extends JpaRepository<GerekliBelgeler, Integer> {
}
