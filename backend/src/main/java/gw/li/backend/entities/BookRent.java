package gw.li.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book_rents")
public class BookRent {
    @EmbeddedId
    BookRentId id;

    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime updatedAt;

    public BookRent(Person person, Book book) {
        OffsetDateTime now = OffsetDateTime.now();
        this.id = new BookRentId(person.getId(), book.getId());
        this.updatedAt = now;
    }
}