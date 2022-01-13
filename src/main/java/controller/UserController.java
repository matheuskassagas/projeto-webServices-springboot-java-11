package controller;

import entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @GetMapping
    public ResponseEntity<?> findAll(){
        User user = new User(1, "Matheus", "matheus@hotmail.com", "12345", "(34)9991200027");
        return ResponseEntity.ok().body(user);
    }
}
