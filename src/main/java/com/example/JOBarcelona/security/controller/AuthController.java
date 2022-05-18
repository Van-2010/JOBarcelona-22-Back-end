package com.example.JOBarcelona.security.controller;

import com.example.JOBarcelona.dto.Message;
import com.example.JOBarcelona.security.dto.JwtDto;
import com.example.JOBarcelona.security.dto.LoginUsuario;
import com.example.JOBarcelona.security.dto.NuevoUsuario;
import com.example.JOBarcelona.security.entity.Rol;
import com.example.JOBarcelona.security.entity.Usuario;
import com.example.JOBarcelona.security.enums.RolName;
import com.example.JOBarcelona.security.jwt.JwtProvider;
import com.example.JOBarcelona.security.service.RolService;
import com.example.JOBarcelona.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("wrong fields or invalid email"), HttpStatus.BAD_REQUEST);
        if(userService.existsByUsername(newUser.getUsername()))
            return new ResponseEntity(new Message("this name already exists"), HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("that email already exists"), HttpStatus.BAD_REQUEST);
        Usuario user =
                new Usuario(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> rols = new HashSet<>();
        rols.add(rolService.getByRolNombre(RolName.ROLE_USER).get());
        if(newUser.getRols().contains("admin"))
            rols.add(rolService.getByRolNombre(RolName.ROLE_ADMIN).get());
        user.setRols(rols);
        userService.save(user);
        return new ResponseEntity(new Message("saved user"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("misplaced fields"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
