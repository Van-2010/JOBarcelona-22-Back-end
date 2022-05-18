package com.example.JOBarcelona.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.JOBarcelona.repository.OrdinaryUserRepository;
import com.example.JOBarcelona.security.dto.NuevoUsuario;
import com.example.JOBarcelona.security.entity.Usuario;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.ResourceUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrdinaryUserService {

    @Autowired
    private OrdinaryUserRepository ordinaryUserRepository;

    public List<NuevoUsuario> getAllUsers() {
        return ordinaryUserRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    public String getFileJson() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("data.json");
        byte[] bytes = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
        return new String(bytes);
    }
    private NuevoUsuario convertEntityToDto(Usuario usuario) {
        NuevoUsuario usuarioDto = new NuevoUsuario();
        usuarioDto.setName(usuario.getName());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setUsername(usuario.getUsername());
        usuarioDto.setPassword(usuario.getPassword());
        return usuarioDto;
    }
}








