package de.jaufmann.mosterei;

import de.jaufmann.mosterei.model.Mosten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MostenRepository extends JpaRepository<Mosten, Long> {
}
