package gw.li.backend.repositories;

import gw.li.backend.entities.AuthorBook;
import gw.li.backend.entities.AuthorBookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorBookRepository extends JpaRepository<AuthorBook, AuthorBookId> {
}
