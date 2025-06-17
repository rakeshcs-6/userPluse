package com.example.userPluseapi.Repository;

import com.example.userPluseapi.Model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {

    @Query("Select u from UserModel  u where u.email  = :email")
    Optional<UserModel> findByEmail(@NotBlank(message = "Email is required") @Email String email);
}
