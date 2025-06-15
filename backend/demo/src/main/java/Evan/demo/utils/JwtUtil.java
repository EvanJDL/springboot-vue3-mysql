package Evan.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String KEY = "your-very-secret-key";

    public static String genToken(Map<String, Object> claims) {
        JWTCreator.Builder builder = JWT.create();

        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                builder.withClaim(key, (Integer) value);
            } else if (value instanceof String) {
                builder.withClaim(key, (String) value);
            }

        }

        builder.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12));
        return builder.sign(Algorithm.HMAC256(KEY));
    }


    public static Claims parseToken(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token);

        Integer id = jwt.getClaim("id").asInt();
        String username = jwt.getClaim("username").asString();

        return new Claims(id, username);
    }

}
