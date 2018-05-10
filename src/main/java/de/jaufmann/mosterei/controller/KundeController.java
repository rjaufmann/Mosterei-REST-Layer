package de.jaufmann.mosterei.controller;

import de.jaufmann.mosterei.KundeRepository;
import de.jaufmann.mosterei.ResourceNotFoundException;
import de.jaufmann.mosterei.model.Kunden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
}
