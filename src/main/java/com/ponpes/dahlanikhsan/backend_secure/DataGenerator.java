package com.ponpes.dahlanikhsan.backend_secure;

import com.ponpes.dahlanikhsan.app_secure.HasLogger;
import com.ponpes.dahlanikhsan.app_secure.security.Role;
import com.ponpes.dahlanikhsan.backend.domain.security.FUser;
import com.ponpes.dahlanikhsan.backend.service.security.UserRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Random;

@SpringComponent
public class DataGenerator implements HasLogger {


	private final Random random = new Random(1L);

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public DataGenerator(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostConstruct
	public void loadData() {
		if (userRepository.count() != 0L) {
			getLogger().info("Using existing database");
			return;
		}

		getLogger().info("Generating demo data");

		getLogger().info("... generating users");
		FUser baker = createBaker(userRepository, passwordEncoder);
		FUser barista = createBarista(userRepository, passwordEncoder);
		createAdmin(userRepository, passwordEncoder);
		// A set of products without constrains that can be deleted
		createDeletableUsers(userRepository, passwordEncoder);


		getLogger().info("Generated demo data");
	}

	private <T> T getRandom(T[] array) {
		return array[random.nextInt(array.length)];
	}


	private FUser createBaker(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return userRepository.save(
				createUser("baker@vaadin.com", "Heidi", "Carter", passwordEncoder.encode("baker"), Role.BAKER, false));
	}

	private FUser createBarista(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return userRepository.save(createUser("barista@vaadin.com", "Malin", "Castro",
				passwordEncoder.encode("barista"), Role.BARISTA, true));
	}

	private FUser createAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return userRepository.save(
				createUser("admin@vaadin.com", "Göran", "Rich", passwordEncoder.encode("admin"), Role.ADMIN, true));
	}

	private void createDeletableUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		userRepository.save(
				createUser("peter@vaadin.com", "Peter", "Bush", passwordEncoder.encode("peter"), Role.BARISTA, false));
		userRepository
				.save(createUser("mary@vaadin.com", "Mary", "Ocon", passwordEncoder.encode("mary"), Role.BAKER, true));
	}

	private FUser createUser(String email, String firstName, String lastName, String passwordHash, String role,
                            boolean locked) {
		FUser user = new FUser();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPasswordHash(passwordHash);
		user.setRole(role);
		user.setLocked(locked);
		return user;
	}
}
