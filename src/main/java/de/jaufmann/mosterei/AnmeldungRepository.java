package de.jaufmann.mosterei;

import de.jaufmann.mosterei.model.Anmeldungen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnmeldungRepository extends JpaRepository<Anmeldungen, Long> {
}
