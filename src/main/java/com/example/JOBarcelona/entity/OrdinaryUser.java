package com.example.JOBarcelona.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/*
@Entity
@Table(name = "users")
public class OrdinaryUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Transient
    private List<OrdinaryUser> lista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdinaryUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public OrdinaryUser() {
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

    public List<OrdinaryUser> getLista() {

        return lista;
    }

    public void setLista(List<OrdinaryUser> lista) {

        this.lista = lista;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lista=" + lista +
                '}';
    }
}

*/