package gw.li.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class BookRentId implements Serializable {
    @Column(name = "person_id", nullable = false)
    private Long person_id;
    @Column(name = "book_id", nullable = false)
    private Long book_id;
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime createdAt;
}
