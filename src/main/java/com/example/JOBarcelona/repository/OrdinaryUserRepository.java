package com.example.JOBarcelona.repository;

import com.example.JOBarcelona.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdinaryUserRepository extends JpaRepository<Usuario, Long> {

    //User findByUsername(String username);
    Usuario findById(long id);
    Usuario findByEmail(String email);
    void deleteByUsername(String username);
    List<Usuario> findByUsername(String username);
    //List<OrdinaryUserDto> getLista();
}