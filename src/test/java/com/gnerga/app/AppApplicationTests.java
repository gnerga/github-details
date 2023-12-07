package com.gnerga.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(
		properties = {
				"spring.data.mongodb.username=root",
				"spring.data.mongodb.password=root",
				"spring.data.mongodb.database=mongo_db",
				"spring.data.mongodb.port=27017",
				"spring.data.mongodb.host=127.0.0.1",
				"spring.data.mongodb.authentication-database=admin"
		})
class AppApplicationTests {

	@Test
	void contextLoads() {
	}

}
