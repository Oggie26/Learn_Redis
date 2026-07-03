package com.example.redis.controller;

import com.example.redis.dto.CreateUserRequest;
import com.example.redis.dto.UpdateUserRequest;
import com.example.redis.dto.UserResponse;
import com.example.redis.dto.UserSearchRequest;
import com.example.redis.entity.User;
import com.example.redis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest userRequest) {
        return ResponseEntity.ok().body(userService.createUser(userRequest));
    }

    @GetMapping
    public ResponseEntity<UserResponse> getAllUsers(UserSearchRequest userSearchRequest) {
        return ResponseEntity.ok().body(userService.getAllUsers(userSearchRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest userRequest) {
        userService.updateUser(id, userRequest);
        return ResponseEntity.ok().body("User Update Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User Deleted Successfully");
    }

}