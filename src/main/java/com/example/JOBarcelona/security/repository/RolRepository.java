package com.example.JOBarcelona.security.repository;

import com.example.JOBarcelona.security.entity.Rol;
import com.example.JOBarcelona.security.enums.RolName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolName(RolName rolName);
}
