package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final JdbcTemplate jdbcTemplate;

    // Injection de dépendance via le constructeur
    public MessageController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Méthode pour vérifier si la base de données est "up"
    public boolean isDatabaseUp() {
        try {
            // Requête simple pour vérifier la connectivité
            jdbcTemplate.execute("SELECT 1");
            return true;  // Si la requête réussit, la base est "up"
        } catch (Exception e) {
            return false; // Si une exception est lancée, la base est "down"
        }
    }

    @GetMapping("/")
    public String getMessage() {
        // Vérifie si la base de données est "up"
        if (isDatabaseUp()) {
            return "{\"message\":\" Hello from Backend ! Database is UP ! \"}";
        } else {
            return "{\"message\":\" Hello from Backend ! Database is DOWN ! \"}";
        }
    }
}


