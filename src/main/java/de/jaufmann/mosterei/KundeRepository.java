package de.jaufmann.mosterei;

import de.jaufmann.mosterei.model.Kunden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundeRepository extends JpaRepository<Kunden, Long> {
}
