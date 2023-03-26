package gw.li.backend.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class AuthorBookId implements Serializable {
    private int author_id;
    private int book_id;
}
