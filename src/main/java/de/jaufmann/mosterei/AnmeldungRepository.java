package de.jaufmann.mosterei;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.jaufmann.mosterei.model.Anmeldungen;


@Repository
public interface AnmeldungRepository extends JpaRepository<Anmeldungen, Long> {

    @Query(value = "SELECT * FROM anmeldungen a where a.beginn BETWEEN :start AND :ende", nativeQuery = true)
    List<Anmeldungen> findAllByDate(Date start, Date ende);

}
