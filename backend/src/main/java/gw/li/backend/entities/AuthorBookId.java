package gw.li.backend.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class AuthorBookId implements Serializable {
    private int author_id;
    private int book_id;

    public AuthorBookId(Author author, Book book) {
        setAuthor_id(author.getId());
        setBook_id(book.getId());
    }
}
