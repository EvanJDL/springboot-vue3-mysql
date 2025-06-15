package Evan.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Sam");

        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256("your-very-secret-key"));

        System.out.println(token);
    }
    @Test
    public void testParseToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9."+
        "eyJleHAiOjE3NDk1NDY5MjgsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoiU2FtIn19."+
        "CLaRWDi2Qnuvyudnq0SOoLJ8YTrapZPAzt9gr0gMQcA";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("your-very-secret-key")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        Map<String, Claim> claims = decodedJWT.getClaims();

        System.out.println(claims.get("user"));
    }

}