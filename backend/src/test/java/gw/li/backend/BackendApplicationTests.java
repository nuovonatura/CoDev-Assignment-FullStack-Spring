package gw.li.backend;

import gw.li.backend.entities.*;
import gw.li.backend.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

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
	void test1() {
		Author author = new Author("Greg");
		Book book = new Book("Book");

		authorRepository.save(author);
		bookRepository.save(book);

		AuthorBook ab = new AuthorBook(author, book);

		authorBookRepository.save(ab);

		authorRepository.findAll().forEach(System.out::println);
		bookRepository.findAll().forEach(System.out::println);
		authorBookRepository.findAll().forEach(System.out::println);
	}

}
