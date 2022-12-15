package ntplug.ntplug.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("message")
public class MessageController {
    @GetMapping("/user")
    User getUser() {
        return new User("login", "password");
    }

    @PostMapping("/user")
    UserPost postUser(@RequestBody User user) {
        return new UserPost(user.getLogin(), String.valueOf(new Date()));
    }
}
