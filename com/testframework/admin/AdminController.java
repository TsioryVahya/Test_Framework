package testFramework.com.testframework.admin;

import framework.annotation.Controller;
import framework.annotation.GetMapping;

@Controller
public class AdminController {
    
    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "Admin dashboard";
    }
    
    @GetMapping("/admin/settings")
    public String settings() {
        return "Admin settings";
    }
}
