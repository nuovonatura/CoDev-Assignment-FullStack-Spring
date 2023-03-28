package gw.li.backend.repositories;

import gw.li.backend.entities.Book;
import gw.li.backend.entities.BookRent;
import gw.li.backend.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRentRepository extends JpaRepository<BookRent, Long> {
    @Query(value = "SELECT b FROM " +
            "(SELECT br.id.book_id AS book_id FROM BookRent br " +
            "GROUP BY br.id.book_id HAVING COUNT(br.id.book_id) >= 1 " +
            "ORDER BY COUNT(br.id.book_id) DESC LIMIT 3) l " +
            "JOIN Book b ON l.book_id = b.id")
    List<Book> findTop3RentedBooks();

    @Query(value = "SELECT p FROM " +
            "(SELECT br.id.person_id AS person_id, COUNT(br.id.person_id) AS count " +
            "FROM BookRent br WHERE br.id.book_id = :book_id " +
            "GROUP BY br.id.person_id HAVING COUNT(br.id.person_id) >= 1 " +
            "ORDER BY COUNT(br.id.person_id) DESC) l " +
            "JOIN Person p ON l.person_id = p.id WHERE p.country_id = :country_id ORDER BY l.count LIMIT 3")
    List<Person> findTop3PeopleByBookAndCountry(@Param("book_id") int book_id, @Param("country_id") long country_id);
}
