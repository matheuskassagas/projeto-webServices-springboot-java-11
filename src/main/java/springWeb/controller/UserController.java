package springWeb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springWeb.DTO.request.UserRequest;
import springWeb.DTO.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springWeb.repositoryJPA.entity.User;
import springWeb.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<UserResponse> userAll = userService.findAll();
        return ResponseEntity.ok().body(userAll);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<?> create (@RequestBody UserRequest userRequest){
        User userNew = userService.create(userRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userNew.getId()).toUri();
        return ResponseEntity.created(uri).body(userNew);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody UserRequest userRequest){
        User newUser = userService.update(id, userRequest);
        return ResponseEntity.ok().body(newUser);
    }
}
