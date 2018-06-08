package de.jaufmann.mosterei.controller;

import de.jaufmann.mosterei.KundeRepository;
import de.jaufmann.mosterei.ResourceNotFoundException;
import de.jaufmann.mosterei.model.Anmeldungen;
import de.jaufmann.mosterei.model.Kunden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class KundeController {

    private static final Logger logger = Logger.getLogger(KundeController.class.getName());

    @Autowired
    KundeRepository kundeRepository;

    // Get all kunden
    @GetMapping("/kunden")
    public List<Kunden> getAllNotes() {
        return kundeRepository.findAll();
    }

    // Get a Single kunde
    @GetMapping("/kunden/{id}")
    public Kunden getNoteById(@PathVariable(value = "id") Long id) {
        return kundeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kunden", "ID", id));
    }

    @PostMapping(path = "/update_kunde", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public void updateKunde(@RequestBody Kunden kunde) {
        logger.log(Level.INFO, "updateKunde called: " + kunde.toString());
        kundeRepository.save(kunde);
        return;
    }
}
