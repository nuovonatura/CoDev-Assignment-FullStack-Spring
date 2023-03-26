package gw.li.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "people")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "people_id_seq")
    @SequenceGenerator(name = "people_id_seq", sequenceName = "people_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "createdAt", nullable = false)
    private OffsetDateTime createdAt;
    @Column(name = "updatedAt", nullable = false)
    private OffsetDateTime updatedAt;
    @Column(name = "country_id")
    private Long country_id;
}
