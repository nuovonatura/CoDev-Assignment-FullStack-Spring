package gw.li.backend;

import gw.li.backend.entities.*;
import gw.li.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
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

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Author author1 = new Author("author1");
		Author author2 = new Author("author2");
		Author author3 = new Author("author3");
		Author author4 = new Author("author4");
		Author author5 = new Author("author5");
		Book book1 = new Book("book1");
		Book book2 = new Book("book2");
		Book book3 = new Book("book3");
		Book book4 = new Book("book4");
		Book book5 = new Book("book5");
		Person person1 = new Person("person1", 65);
		Person person2 = new Person("person2", 65);
		Person person3 = new Person("person3", 65);
		Person person4 = new Person("person4", 60);
		Person person5 = new Person("person5", 1);
		AuthorBook authorBook1 = new AuthorBook(author1, book1);
		AuthorBook authorBook2 = new AuthorBook(author2, book2);
		AuthorBook authorBook3 = new AuthorBook(author3, book2);
		AuthorBook authorBook4 = new AuthorBook(author3, book3);
		AuthorBook authorBook5 = new AuthorBook(author4, book4);
		AuthorBook authorBook6 = new AuthorBook(author5, book5);
		authorRepository.saveAll(List.of(author1, author2, author3, author4, author5));
		bookRepository.saveAll(List.of(book1, book2, book3, book4, book5));
		personRepository.saveAll(List.of(person1, person2, person4, person3, person5));
		authorBookRepository.saveAll(List.of(authorBook1, authorBook2, authorBook3,
				authorBook4, authorBook5, authorBook6));

		BookRent bookRent1 = new BookRent(person1, book1);
		BookRent bookRent2 = new BookRent(person1, book1);
		BookRent bookRent3 = new BookRent(person1, book1);
		BookRent bookRent4 = new BookRent(person2, book1);
		BookRent bookRent5 = new BookRent(person2, book1);
		BookRent bookRent6 = new BookRent(person3, book1);
		BookRent bookRent7 = new BookRent(person4, book1);
		BookRent bookRent8 = new BookRent(person1, book2);
		BookRent bookRent9 = new BookRent(person1, book3);
		BookRent bookRent10 = new BookRent(person4, book2);
		BookRent bookRent11 = new BookRent(person3, book2);
		BookRent bookRent12 = new BookRent(person1, book2);
		BookRent bookRent13 = new BookRent(person3, book2);
		BookRent bookRent14 = new BookRent(person5, book3);

		bookRentRepository.saveAll(List.of(bookRent1, bookRent2, bookRent3, bookRent4, bookRent5,
				bookRent6, bookRent7, bookRent8, bookRent9, bookRent10, bookRent11, bookRent12,
				bookRent13, bookRent14));
	}
}
