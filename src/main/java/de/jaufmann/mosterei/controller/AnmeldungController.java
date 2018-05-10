package de.jaufmann.mosterei.controller;

import de.jaufmann.mosterei.AnmeldungRepository;
import de.jaufmann.mosterei.ResourceNotFoundException;
import de.jaufmann.mosterei.model.Anmeldungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class AnmeldungController {

    private static final Logger logger = Logger.getLogger(AnmeldungController.class.getName());

    @Autowired
    AnmeldungRepository anmeldungRepository;

    // Get all anmeldungen
    @GetMapping("/anmeldungen")
    public List<Anmeldungen> getAllNotes() {
        return anmeldungRepository.findAll();
    }

    // Get a Single anmeldung
    @GetMapping("/anmeldungen/{id}")
    public Anmeldungen getNoteById(@PathVariable(value = "id") Long id) {
        return anmeldungRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anmeldung", "ID", id));
    }
}
