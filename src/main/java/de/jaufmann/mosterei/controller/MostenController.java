package de.jaufmann.mosterei.controller;

import de.jaufmann.mosterei.MostenRepository;
import de.jaufmann.mosterei.ResourceNotFoundException;
import de.jaufmann.mosterei.model.Mosten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class MostenController {

    private static final Logger logger = Logger.getLogger(MostenController.class.getName());

    @Autowired
    MostenRepository mostenRepository;

    // Get all kunden
    @GetMapping("/mosten")
    public List<Mosten> getAllNotes() {
        return mostenRepository.findAll();
    }

    // Get a Single kunde
    @GetMapping("/mosten/{id}")
    public Mosten getNoteById(@PathVariable(value = "id") Long id) {
        return mostenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mosten", "ID", id));
    }

    @PostMapping(path = "/mosten", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public void updateMosten(@RequestBody Mosten mosten) {
        logger.log(Level.INFO, "updateMosten called: " + mosten.toString());
        mostenRepository.save(mosten);
        return;
    }
}
