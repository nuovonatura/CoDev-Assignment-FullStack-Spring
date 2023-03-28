package gw.li.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "people_id_seq")
    @SequenceGenerator(name = "people_id_seq", sequenceName = "people_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime createdAt;
    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime updatedAt;
    @Column(name = "country_id")
    private long country_id;

    public Person(String name, long country_id) {
        OffsetDateTime now = OffsetDateTime.now();
        this.name = name;
        this.country_id = country_id;
        this.createdAt = now;
        this.updatedAt = now;
    }
}
