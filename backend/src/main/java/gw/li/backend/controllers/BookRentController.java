package gw.li.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import gw.li.backend.entities.Author;
import gw.li.backend.entities.Book;
import gw.li.backend.entities.Person;
import gw.li.backend.services.BookRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.List;

@RestController
public class BookRentController {
    @Autowired
    private BookRentService bookRentService;

    private long validateCountryCode(String country_code) {
        Map<String, Long> countryCodes = Map.of("SG", (long)65, "MY", (long)60, "US", (long)1);
        return countryCodes.containsKey(country_code) ? countryCodes.get(country_code) : -1;
    }

    @GetMapping("/getTop3ReadBooks")
    @Transactional
    public ResponseEntity<Object> getTop3ReadBooks(@RequestParam("country_code") String country_code) {
        long country_id = validateCountryCode(country_code);

        ObjectMapper objectMapper = new ObjectMapper();

        if (country_id == -1) {
            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("message", "invalid parameter");
            try{
                String body = objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(jsonNode);
                return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<Book, List<Person>> result = bookRentService.getTop3RentedBook(country_id);

        if (result.isEmpty()) {
            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("message", "no results");
            try{
                String body = objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(jsonNode);
                return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ArrayNode body = objectMapper.createArrayNode();
        for (Book book : result.keySet()) {
            ObjectNode bookResult = objectMapper.createObjectNode();

            List<String> authors = book.getAuthors().stream().map(Author::getName).toList();
            bookResult.put("author", String.join(", ", authors));

            bookResult.put("name", book.getName());

            List<String> people = result.get(book).stream().map(Person::getName).toList();
            ArrayNode top3People = objectMapper.createArrayNode();
            for (String person : people) {
                top3People.add(person);
            }
            bookResult.set("borrower", top3People);

            body.add(bookResult);
        }

        try {
            String stringBody = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(body);
            return new ResponseEntity<>(stringBody, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
