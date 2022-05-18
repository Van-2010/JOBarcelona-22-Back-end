package com.example.JOBarcelona.security.service;

import com.example.JOBarcelona.security.entity.Usuario;
import com.example.JOBarcelona.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario user){

        usuarioRepository.save(user);
    }


}