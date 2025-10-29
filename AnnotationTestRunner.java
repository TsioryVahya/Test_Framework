package testFramework;

import framework.annotation.AnnotationReader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AnnotationTestRunner {
    
    public static void main(String[] args) {
        System.out.println("=== Test des annotations ===\n");
        
        // Découverte automatique des classes dans le package testFramework
        Class<?>[] testClasses = discoverClasses("testFramework");
        
        System.out.println("Classes découvertes dans le package testFramework:");
        for (Class<?> clazz : testClasses) {
            System.out.println("- " + clazz.getSimpleName());
        }
        System.out.println();
        
        // Afficher les classes qui utilisent @GetMapping au niveau méthode
        AnnotationReader.displayClassesWithAnnotations(testClasses);
        
        System.out.println("\n=== Test individuel des classes ===");
        
        // Test individuel de chaque classe
        for (Class<?> clazz : testClasses) {
            System.out.println("\nTest de la classe: " + clazz.getSimpleName());
            try {
                AnnotationReader.readGetMappingAnnotations(clazz);
            } catch (Exception e) {
                System.out.println("Erreur lors du test de " + clazz.getSimpleName() + ": " + e.getMessage());
            }
        }
    }
    
    /**
     * Découvre automatiquement toutes les classes dans un package donné
     */
    private static Class<?>[] discoverClasses(String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        
        try {
            String path = packageName.replace('.', '/');
            URL resource = ClassLoader.getSystemClassLoader().getResource(path);
            
            if (resource != null) {
                File directory = new File(resource.getFile());
                
                if (directory.exists()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.isFile() && file.getName().endsWith(".class")) {
                                String className = file.getName().substring(0, file.getName().length() - 6);
                                try {
                                    Class<?> clazz = Class.forName(packageName + "." + className);
                                    classes.add(clazz);
                                } catch (ClassNotFoundException e) {
                                    System.out.println("Impossible de charger la classe: " + className);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la découverte des classes: " + e.getMessage());
        
        }
        
        return classes.toArray(new Class<?>[0]);
    }
}
