package com.example.JOBarcelona.controller;

import com.example.JOBarcelona.security.dto.NuevoUsuario;
import com.example.JOBarcelona.security.entity.Usuario;
import com.example.JOBarcelona.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class OrdinaryUserController {

    @Autowired
    OrdinaryUserService ordinaryUserService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<List<NuevoUsuario>> getAll() {
        List<NuevoUsuario> usuarios=ordinaryUserService.getAllUsers();
        return new ResponseEntity<List<NuevoUsuario>>(usuarios, HttpStatus.FOUND);
    }
    /*@GetMapping("/jsonList")
    public ResponseEntity<Map<?,?>>getFromJson() throws IOException {
        Map<?,?>jsonList=ordinaryUserService.GetJsonList();
        return new ResponseEntity<Map<?,?>>(jsonList, HttpStatus.FOUND);
    }*/
    @GetMapping("/jsonListas")
    public ResponseEntity<List<?>>getFromJson2() throws IOException {
        List jsonList= Collections.singletonList(ordinaryUserService.getFileJson());
        return new ResponseEntity<List<?>>(jsonList, HttpStatus.FOUND);
    }


}


