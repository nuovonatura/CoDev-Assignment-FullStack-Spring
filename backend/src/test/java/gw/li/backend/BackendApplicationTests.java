package gw.li.backend;

import gw.li.backend.entities.Author;
import gw.li.backend.entities.AuthorBook;
import gw.li.backend.entities.AuthorBookId;
import gw.li.backend.entities.Book;
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

		AuthorBook ab = new AuthorBook();
		ab.setId(new AuthorBookId(author, book));
		ab.setAuthor(author);
		ab.setBook(book);
		OffsetDateTime now = OffsetDateTime.now();
		ab.setCreatedAt(now);
		ab.setUpdatedAt(now);

		authorBookRepository.save(ab);

		authorRepository.findAll().forEach(System.out::println);
		bookRepository.findAll().forEach(System.out::println);
		authorBookRepository.findAll().forEach(System.out::println);
	}

}
