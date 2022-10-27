package com.codewithhades.springboot.api.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final List<User> users;

    public UsersController() {
        this.users = new CopyOnWriteArrayList<>();
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest) {
        User user = new User(userRequest.getName(), userRequest.getSurname());
        users.add(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(user -> {
                    user.setName(userRequest.getName());
                    user.setSurname(userRequest.getSurname());
                    return user;
                })
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        User userToDelete = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (userToDelete != null && users.remove(userToDelete)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
