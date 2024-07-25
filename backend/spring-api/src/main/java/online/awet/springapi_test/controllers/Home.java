package online.awet.springapi_test.controllers;

import online.awet.springapi_test.conf.Routes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Home {

    @GetMapping(Routes.HOME)
    public String home() {
        return "Hello World!";
    }

    @GetMapping(Routes.TEST)
    public String test() {
        return "Test!";
    }

}
