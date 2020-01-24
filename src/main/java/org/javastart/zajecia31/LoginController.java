package org.javastart.zajecia31;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/przelew")
    @ResponseBody
    public String hacked() {
        return "Twoje pieniądze zostały przelane na konto atakującego";
    }

}
