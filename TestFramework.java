package testFramework;

import framework.annotation.GetMapping;
import framework.annotation.AnnotationReader;

public class TestFramework {
    
    @GetMapping("/index")
    public void indexMethod() {
        // Méthode avec annotation @GetMapping
    }
    
    @GetMapping("/home")
    public void homeMethod() {
        // Autre méthode avec annotation @GetMapping
    }
    
    @GetMapping("/users")
    public void usersMethod() {
        // Troisième méthode avec annotation @GetMapping
    }
    
    public void methodWithoutAnnotation() {
        // Méthode sans annotation
    }
    
    public static void main(String[] args) {
        System.out.println("=== Test des annotations @GetMapping ===");
        
        // Lire les annotations de la classe TestFramework
        AnnotationReader.readGetMappingAnnotations(TestFramework.class);
        
        System.out.println("=== Fin du test ===");
    }
}
