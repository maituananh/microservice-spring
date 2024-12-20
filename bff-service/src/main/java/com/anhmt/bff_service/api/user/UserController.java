package com.anhmt.bff_service.api.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping
    public void createUser() {
//        userService.save();

    }

    @PutMapping
    public void updateUser() {

    }

    @GetMapping
    public String getUser() {
        return "Hello World";
    }
}
