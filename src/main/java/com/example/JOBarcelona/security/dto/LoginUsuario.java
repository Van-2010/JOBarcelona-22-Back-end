package com.example.JOBarcelona.security.dto;


public class LoginUsuario {
   
    private String username;
    
    private String password;

    public String getNombreUsuario() {
        return username;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.username = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
