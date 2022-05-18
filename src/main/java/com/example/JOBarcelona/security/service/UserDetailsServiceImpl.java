package com.example.JOBarcelona.security.service;

import com.example.JOBarcelona.security.entity.UsuarioPrincipal;
import com.example.JOBarcelona.security.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userService.getByUsername(username).get();
        return UsuarioPrincipal.build(user);
    }
}
