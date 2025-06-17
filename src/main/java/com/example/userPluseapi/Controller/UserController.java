package com.example.userPluseapi.Controller;


import com.example.userPluseapi.DTO.UserDTO;
import com.example.userPluseapi.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String saveUsers(@Valid @RequestBody UserDTO userDTO){

        return  userService.saveUser(userDTO);

    }
}
