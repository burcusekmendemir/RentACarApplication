package com.burcu.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.burcu.exception.ErrorType;
import com.burcu.exception.VehicleServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    @Value("${jwt.secretKey}")
    private String SECRETKEY;
    @Value("${jwt.issuer}")
    private String ISSUER;
    @Value("${jwt.audience}")
    private String AUDIENCE;
    private Long EXDATE= 1000L*60*5;


    /**
     * Token yaratmak için kullanılan methodtur.
     */

    public Optional<String> createToken(Long id){
        String token;
        try {
            token= JWT.create()
                    .withIssuer(ISSUER)
                    .withAudience(AUDIENCE)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXDATE))
                    .withClaim("id",id)
                    .sign(Algorithm.HMAC512(SECRETKEY));
            return Optional.of(token);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public Boolean validateToken(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC512(SECRETKEY);
            JWTVerifier jwtVerifier=JWT.require(algorithm).withIssuer(ISSUER).withAudience(AUDIENCE).build();
            DecodedJWT decodedJWT= jwtVerifier.verify(token);
            if (decodedJWT==null){
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new VehicleServiceException(ErrorType.INVALID_TOKEN);

        }
        return true;
    }

    /**
     * createToken() methoduyla oluşturulan tokenın doğruluğunu kontrol eden methodtur.
     * @param token
     * @return
     */
    public Optional<Long> getIdFromToken(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC512(SECRETKEY);
            JWTVerifier verifier=JWT.require(algorithm).withIssuer(ISSUER).withAudience(AUDIENCE).build();
            DecodedJWT decodedJWT= verifier.verify(token);

            if (decodedJWT==null){
                throw new VehicleServiceException(ErrorType.INVALID_TOKEN);
            }

            Long id=decodedJWT.getClaim("id").asLong();
            return Optional.of(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new VehicleServiceException(ErrorType.INVALID_TOKEN);
        }
    }

    public Optional<String> getRoleFromToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRETKEY);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).withAudience(AUDIENCE).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            if (decodedJWT == null) {
                throw new VehicleServiceException(ErrorType.INVALID_TOKEN);
            }

            String role = decodedJWT.getClaim("role").asString();
            return Optional.of(role);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new VehicleServiceException(ErrorType.INVALID_TOKEN);
        }
    }



}
