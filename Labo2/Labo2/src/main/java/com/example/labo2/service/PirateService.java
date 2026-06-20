package com.example.labo2.service;


import com.example.labo2.entity.Pirate;
import com.example.labo2.repository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PirateService {

    @Autowired
    private PirateRepository pirateRepository;

    public Pirate createPirate(Pirate pirate) {
        return pirateRepository.save(pirate);
    }

    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    public Pirate getPirateById(UUID id) {
        return pirateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pirata no encontrado con id: " + id));
    }

    public Pirate updatePirate(UUID id, Pirate pirateDetails) {
        Pirate pirate = getPirateById(id);
        pirate.setName(pirateDetails.getName());
        pirate.setBounty(pirateDetails.getBounty());
        pirate.setCrew(pirateDetails.getCrew());
        pirate.setIsAlive(pirateDetails.getIsAlive());
        return pirateRepository.save(pirate);
    }

    public void deletePirate(UUID id) {
        Pirate pirate = getPirateById(id);
        pirateRepository.delete(pirate);
    }
}

