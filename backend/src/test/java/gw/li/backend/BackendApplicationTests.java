package gw.li.backend;

import gw.li.backend.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AuthorBookRepository authorBookRepository;
	@Autowired
	private BookRentRepository bookRentRepository;

	@Test
	void author() {
	}

}
