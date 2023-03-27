package gw.li.backend.services;

import gw.li.backend.entities.Book;
import gw.li.backend.entities.Person;
import gw.li.backend.repositories.BookRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bookRentService")
public class BookRentService {
    @Autowired
    private BookRentRepository bookRentRepository;

    public Map<Book, List<Person>> getTop3RentedBook(Long country_id) {
        HashMap<Book, List<Person>> res = new HashMap<>();

        List<Book> top3RentedBooks = bookRentRepository.findTop3RentedBooks();

        for (Book b : top3RentedBooks) {
            res.put(b, bookRentRepository.findTop3PeopleByBookAndCountry(b.getId(), country_id));
        }

        return res;
    }
}
