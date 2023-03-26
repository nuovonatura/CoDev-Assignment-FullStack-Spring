package gw.li.backend.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class BookRentId implements Serializable {
    private Long person_id;
    private Long book_id;
}
