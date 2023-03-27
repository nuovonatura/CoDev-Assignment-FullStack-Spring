package gw.li.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "author_books")
@Data
public class AuthorBook implements Serializable {
    @EmbeddedId
    AuthorBookId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("author_id")
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("book_id")
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;

    @Column(name = "createdAt", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private OffsetDateTime updatedAt;
}