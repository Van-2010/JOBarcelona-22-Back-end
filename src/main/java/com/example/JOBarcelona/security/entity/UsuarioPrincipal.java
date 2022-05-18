package com.example.JOBarcelona.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    //encargada de la seguretat
//implementa el tema dels privilegis de cada usuari
//converteix el rol en authorities(mètode propi de la seguretat de Spring
//obté l'autorització de l'usuari

        private String name;
        private String username;
        private String email;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;//classe propia de la seguretat de spring

        public UsuarioPrincipal(String name, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
            this.name = name;
            this.username = username;
            this.email = email;
            this.password = password;
            this.authorities = authorities;
        }

        public static UsuarioPrincipal build(Usuario user){//per estaablir els privilegis dels usuaris
            List<GrantedAuthority> authorities =
                    user.getRols().stream().map(rol -> new SimpleGrantedAuthority(rol //estem convertint la classe rol en la classe GrantedAuthoriy
                            .getRolName().name())).collect(Collectors.toList());
            return new UsuarioPrincipal(user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), authorities);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }


