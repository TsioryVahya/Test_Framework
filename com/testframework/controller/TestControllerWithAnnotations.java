package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;

@Controller
public class TestControllerWithAnnotations {
    
    @GetMapping("/test")
    public String testMethod() {
        return "Test method";
    }
    
    @GetMapping("/hello")
    public String helloMethod() {
        return "Hello world";
    }
    
    public String methodWithoutAnnotation() {
        return "No annotation";
    }
    
    @GetMapping("/bonjour")
    public String bonjour() {
        return "Bonjour du framework";
    }
}
