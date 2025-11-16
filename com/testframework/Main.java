package testFramework.com.testframework;

import framework.annotation.AnnotationReader;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Démarrage de l'application ===\n");
        
        // Initialisation du système au démarrage (scan des URLs une seule fois)
        AnnotationReader.init();
        
        System.out.println("=== Affichage des classes scannées ===\n");
        // Le package de base est défini dans testFramework/resources/config.properties
        AnnotationReader.displayClassesWithAnnotations();
        
        System.out.println("\n=== Test de recherche d'URL ===\n");
        
        // Test avec des URLs existantes
        testUrl("/test");
        testUrl("/hello");
        testUrl("/users");
        testUrl("/users/create");
        testUrl("/admin/dashboard");
        testUrl("/admin/settings");
        
        // Test avec une URL non existante
        testUrl("/nonexistent");
        testUrl("/api/test");
    }
    
    private static void testUrl(String url) {
        System.out.println("\nRecherche de l'URL: " + url);
        AnnotationReader.displayMappingForUrl(url);
    }
}
