package gw.li.backend.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class AuthorBookId implements Serializable {
    private int author_id;
    private int book_id;

    public AuthorBookId(int author_id, int book_id) {
        this.author_id = author_id;
        this.book_id = book_id;
    }
}
