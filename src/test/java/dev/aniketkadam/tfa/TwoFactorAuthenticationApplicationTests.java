package dev.aniketkadam.tfa;

import dev.aniketkadam.tfa.user.User;
import dev.aniketkadam.tfa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TwoFactorAuthenticationApplicationTests {

	private UserRepository repository;

	@Autowired
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Test
	void contextLoads() {
		Optional<User> userOptional = repository.findByEmail("aniket@gmail.com");

		System.out.println(userOptional.get().getEmail());
	}

}
