package lab7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AppConfig.class)
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=create")
class AppTests {

	@SuppressWarnings("rawtypes")
	@Container
	static PostgreSQLContainer container = new PostgreSQLContainer("postgres:12")
		.withUsername("test")
		.withPassword("password")
		.withDatabaseName("test");

	@Autowired
	private BookRepository repository;

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.username", container::getUsername);
	}

	@Test
	@Order(1)
	void insertBook() {
		Book book = new Book();
		book.setName("Seja um Super-Humano!");
		book.setAuthor("Manuel Pinto Coelho");
		repository.saveAndFlush(book);

		Book rep = repository.findById(book.getId()).get();
		assertEquals("Seja um Super-Humano!", rep.getName());
		assertEquals("Manuel Pinto Coelho", rep.getAuthor());
	}

	@Test
	@Order(2)
	void readBooks() {
		List<Book> rep = repository.findAll();
		List<String> names = new ArrayList<>();
		rep.forEach((Book b) -> names.add(b.getName()));

		assertEquals(3, rep.size());
		assertTrue(names.containsAll(Arrays.asList("Mais 365 Dias", "Endometriose", "Se Fosse Perfeito")));
	}

}