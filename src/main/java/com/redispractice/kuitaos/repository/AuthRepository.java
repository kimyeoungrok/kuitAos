package com.redispractice.kuitaos.repository;

import com.redispractice.kuitaos.Entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByUserId(String userId);
}
