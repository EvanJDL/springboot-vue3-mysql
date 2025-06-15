package Evan.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void testGen() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1);
		claims.put("username", "Zhang San");

		String token = JWT.create()
				.withClaim("user", claims)  // Add custom claim with key "user" and value as the map
				.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 12-hour validity
				.sign(Algorithm.HMAC256("itheima")); // Sign the token using HMAC256 with secret "itheima"

		// 3. Print the generated token
		System.out.println(token);
	}
}


