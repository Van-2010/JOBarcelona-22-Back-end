package com.example.JOBarcelona.security.jwt;


import com.example.JOBarcelona.security.entity.UsuarioPrincipal;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


//classe que genera el token

@Component
public class JwtProvider {
	//logger s'utilitza(en desarrollo) per veure quin és el metode que dona error en cas que no funcioni l'aplicació
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

  //aquests son els que tenim a properties
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal mainUser = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;//vàlid
        }catch (MalformedJwtException e){
            logger.error("malformed token");
        }catch (UnsupportedJwtException e){
            logger.error("token not supported");
        }catch (ExpiredJwtException e){
            logger.error("token expired token");
        }catch (IllegalArgumentException e){
            logger.error("empty token ");
        }catch (SignatureException e){
            logger.error("fail signature");
        }
        return false;//fals
    }
}
