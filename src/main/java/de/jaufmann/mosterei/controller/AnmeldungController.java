package de.jaufmann.mosterei.controller;

import de.jaufmann.mosterei.AnmeldungRepository;
import de.jaufmann.mosterei.ResourceNotFoundException;
import de.jaufmann.mosterei.model.Anmeldungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnmeldungController {

    private static final Logger logger = Logger.getLogger(AnmeldungController.class.getName());

    @Autowired
    AnmeldungRepository anmeldungRepository;

    // Get all anmeldungen
    @GetMapping("/anmeldungen")
    public List<Anmeldungen> getAllNotes() {
        List<Anmeldungen> alleAnmeldungen = anmeldungRepository.findAll();
        if (!alleAnmeldungen.isEmpty()) {
            alleAnmeldungen.sort(new Comparator<Anmeldungen>() {
                @Override
                public int compare(Anmeldungen o1, Anmeldungen o2) {
                    return o1.getBeginn().compareTo(o2.getBeginn());
                }
            });
        }
        return alleAnmeldungen;
    }

    // Get a Single anmeldung
    @GetMapping("/anmeldungen/{id}")
    public Anmeldungen getNoteById(@PathVariable(value = "id") Long id) {
        return anmeldungRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anmeldung", "ID", id));
    }

    @GetMapping("/anmeldungen_by_Date/{date}")
    public List<Anmeldungen>getAllNotesByDate(@PathVariable(value = "date") Long date) {
        // Startdatum
        Calendar start = new GregorianCalendar();
        start.setTime(new Date(date));
        start.set(Calendar.HOUR_OF_DAY,0);
        start.set(Calendar.MINUTE,0);
        start.set(Calendar.SECOND,0);
        // Enddatum
        Calendar end = new GregorianCalendar();
        end.setTime(new Date(date));
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);

        logger.log(Level.INFO, "Long: " + date);
        logger.log(Level.INFO, "Start: " + start.toString());
        logger.log(Level.INFO, "End: " + end.toString());

        List<Anmeldungen> alleAnmeldungen = anmeldungRepository.findAllByDate(start.getTime(), end.getTime());
        if (!alleAnmeldungen.isEmpty()) {
            alleAnmeldungen.sort(new Comparator<Anmeldungen>() {
                @Override
                public int compare(Anmeldungen o1, Anmeldungen o2) {
                    return o1.getBeginn().compareTo(o2.getBeginn());
                }
            });
        }

        return alleAnmeldungen;
    }

    @PostMapping(path = "/update_anmeldungen", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Anmeldungen updateAnmeldung(@RequestBody Anmeldungen anmeldungen) {
        logger.log(Level.INFO, "updateAnmeldung called: " + anmeldungen.toString());
        logger.log(Level.INFO, "userID: " + anmeldungen.getUserId());
        return anmeldungRepository.save(anmeldungen);
    }
}
