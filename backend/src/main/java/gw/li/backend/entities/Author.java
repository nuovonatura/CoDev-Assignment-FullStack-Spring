package gw.li.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_id_seq")
    @SequenceGenerator(name = "authors_id_seq", sequenceName = "authors_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "createdAt", nullable = false)
    private OffsetDateTime createdAt;
    @Column(name = "updatedAt", nullable = false)
    private OffsetDateTime updatedAt;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<AuthorBook> authorBooks;
}
