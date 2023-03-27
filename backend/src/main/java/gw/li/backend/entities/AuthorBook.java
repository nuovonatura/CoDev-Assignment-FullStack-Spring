package gw.li.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "author_books")
public class AuthorBook implements Serializable {
    @EmbeddedId
    private AuthorBookId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("author_id")
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("book_id")
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime updatedAt;
}