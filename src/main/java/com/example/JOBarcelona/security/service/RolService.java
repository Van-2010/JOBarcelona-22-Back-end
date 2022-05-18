package com.example.JOBarcelona.security.service;

import com.example.JOBarcelona.security.entity.Rol;
import com.example.JOBarcelona.security.enums.RolName;
import com.example.JOBarcelona.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class RolService {
	
	//només es pot executar una vegada

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolName rolNombre){
        return rolRepository.findByRolName(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}