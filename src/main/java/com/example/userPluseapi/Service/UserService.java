package com.example.userPluseapi.Service;

import com.example.userPluseapi.DTO.UserDTO;
import com.example.userPluseapi.Model.UserModel;
import com.example.userPluseapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String saveUser(UserDTO userDTO){

        Optional<UserModel> user = userRepository.findByEmail(userDTO.getEmail());



        if(user.isPresent()){
            return "Email exist";
        }

        UserModel userModel = new UserModel();
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setPassword(userDTO.getPassword());
        userModel.setCreatedAt(LocalDateTime.now());

        userRepository.save(userModel);

        return "User saved";
    }

    public List<UserDTO> listUsers(){

        List<UserModel> userModels = userRepository.findAll();

        List <UserDTO> userDTOS = new ArrayList<>();

        for(UserModel userModel : userModels){

            UserDTO userDTO = new UserDTO();

            userDTO.setId(userModel.getId());
            userDTO.setName(userModel.getName());
            userDTO.setEmail(userModel.getEmail());
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }
}
