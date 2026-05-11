package com.rahioui.youssef.assurance.repositories;

import com.rahioui.youssef.assurance.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
