package gw.li.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name = "book_rents")
@Data
public class BookRent {

    @Id
    @Column(name = "person_id", nullable = false)
    private Long person;

    @Column(name = "book_id", nullable = false)
    private Long book;

    @Column(name = "createdAt", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private OffsetDateTime updatedAt;
}