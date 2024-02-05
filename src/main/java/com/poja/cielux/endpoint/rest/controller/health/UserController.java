package com.poja.cielux.endpoint.rest.controller.health;

import com.poja.cielux.repository.model.User;
import com.poja.cielux.service.event.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser).getBody();
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable UUID id) {
        return userService.findById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id,@RequestParam String name) throws ChangeSetPersister.NotFoundException {
        return userService.update(id,name);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id){
        userService.deleteById(id);
    }
}
