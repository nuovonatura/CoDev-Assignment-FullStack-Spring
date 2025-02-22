package gw.li.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class BookRentId implements Serializable {
    @Column(name = "person_id", nullable = false)
    private long person_id;
    @Column(name = "book_id", nullable = false)
    private long book_id;
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime createdAt;

    public BookRentId(long person_id, long book_id) {
        this.person_id = person_id;
        this.book_id = book_id;
        this.createdAt = OffsetDateTime.now();
    }
}
