package gw.li.backend.repositories;

import gw.li.backend.entities.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentRepository extends JpaRepository<BookRent, Long> {
}
