package testFramework;

import framework.annotation.Controller;
import framework.annotation.GetMapping;

@Controller("testController")
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
}
