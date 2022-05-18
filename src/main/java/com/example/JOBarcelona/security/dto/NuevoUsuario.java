package com.example.JOBarcelona.security.dto;

import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {

    //private Long id;

    //@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String name;
   
    private String username;

    @Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",message="Wrong email")
    private String email;

    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",message="invalid password")
    private String password;

    private Set<String> rols = new HashSet<>();//ens permet crear un Json amb totes les dades de l'usuari

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRols() {
        return rols;
    }

    public void setRols(Set<String> rols) {
        this.rols = rols;
    }
}
