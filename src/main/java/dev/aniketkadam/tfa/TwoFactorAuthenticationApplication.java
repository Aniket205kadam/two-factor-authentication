package dev.aniketkadam.tfa;

import dev.aniketkadam.tfa.auth.AuthenticationService;
import dev.aniketkadam.tfa.auth.RegisterRequest;
import dev.aniketkadam.tfa.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TwoFactorAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoFactorAuthenticationApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@gmail.com")
					.password("password")
					.role(Role.ADMIN)
					.build();

			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var user = RegisterRequest.builder()
					.firstname("testUser")
					.lastname("testUser")
					.email("test.user@gmail.com")
					.password("user")
					.role(Role.USER)
					.build();

			System.out.println("Test-User token: " + service.register(user).getAccessToken());
		};
	}

}
