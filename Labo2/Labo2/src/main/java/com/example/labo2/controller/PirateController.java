package com.example.labo2.controller;

import com.example.labo2.entity.Pirate;
import com.example.labo2.service.PirateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirates")
public class PirateController {

    @Autowired
    private PirateService pirateService;

    @PostMapping
    public ResponseEntity<Pirate> createPirate(@RequestBody Pirate pirate) {
        Pirate created = pirateService.createPirate(pirate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pirate>> getAllPirates() {
        return ResponseEntity.ok(pirateService.getAllPirates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirate> getPirateById(@PathVariable UUID id) {
        return ResponseEntity.ok(pirateService.getPirateById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pirate> updatePirate(@PathVariable UUID id, @RequestBody Pirate pirate) {
        return ResponseEntity.ok(pirateService.updatePirate(id, pirate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePirate(@PathVariable UUID id) {
        pirateService.deletePirate(id);
        return ResponseEntity.noContent().build();
    }
}
