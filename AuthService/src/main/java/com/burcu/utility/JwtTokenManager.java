package com.burcu.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.burcu.utility.enums.ERole;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    private String SECRETKEY="5IkZjulrf770YujKrlMJJ89DcffaqbVr0RqXGQBmhHN3nkMalT";
    private String ISSUER = "rentACarAuth";
    private Long EXDATE= 1000L*60*5;


    /**
     * Token yaratmak için kullanılan methodtur.
     * @param authId
     * @return
     */

    public Optional<String> createToken(Long authId, ERole role){  // TODO: role ile alakalı bir token da oluşturulmalı mı?
        String token;
        try {
            token= JWT.create()
                    .withClaim("authId",authId)
                    .withClaim("role", role.toString())
                    .withIssuer(ISSUER)
                    .withAudience()
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXDATE))
                    .sign(Algorithm.HMAC512(SECRETKEY));
            return Optional.of(token);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    /**
     * createToken() methoduyla oluşturulan tokenın doğruluğunu kontrol eden methodtur.
     * @param token
     * @return
     */
    public Optional<Long> validateToken(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC512(SECRETKEY);
            JWTVerifier jwtVerifier=JWT.require(algorithm).withIssuer(ISSUER).build();
            DecodedJWT decodedJWT= jwtVerifier.verify(token);
            if (decodedJWT==null){
                return Optional.empty();
            }
            Long authId=decodedJWT.getClaim("authId").asLong();
            return Optional.of(authId);
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
