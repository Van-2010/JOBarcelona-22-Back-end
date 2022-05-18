package com.example.JOBarcelona.security.entity;

import com.example.JOBarcelona.security.enums.RolName;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)//per indicar que es tracta d'una cadena, sino a la base de dades ens sortiria un ordinal
    private RolName rolName;

    public Rol() {
    }
    public Rol(@NotNull RolName rolName) {
        this.rolName = rolName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolName getRolName() {
        return rolName;
    }

    public void setRolName(RolName rolName) {
        this.rolName = rolName;
    }
}



