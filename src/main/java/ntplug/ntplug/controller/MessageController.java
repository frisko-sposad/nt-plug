package ntplug.ntplug.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Vector;

@RestController
@RequestMapping("message")
public class MessageController {
    DBWorker db = new DBWorker();

    @GetMapping(value = "/user")
    User getUser(@RequestParam String login) {
        try {
            User u = db.getUser(login);
            return u;
        } catch (Exception e) {

        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "user not found"
        );
    }

    @GetMapping(value = "/users")
    Vector<User> getUsers() {
        try {
            Vector<User> u = db.getAllUsers();
            return u;
        } catch (Exception e) {

        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "users not found"
        );
    }


    @PostMapping("/user")
    UserPost postUser(@RequestBody User user) {
        return new UserPost(user.getLogin(), String.valueOf(new Date()));
    }
}
