package com.example.labo2.repository;

import com.example.labo2.entity.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PirateRepository extends JpaRepository<Pirate, UUID> {
}
