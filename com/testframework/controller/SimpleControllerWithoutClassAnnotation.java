package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
@Controller
public class SimpleControllerWithoutClassAnnotation {
    
    @GetMapping("/simple")
    public String simpleMethod() {
        return "Simple method";
    }
    
    @GetMapping("/another")
    public String anotherMethod() {
        return "Another method";
    }
}
