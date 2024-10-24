package com.example.demo.services;
import com.example.demo.db.entity.User;
import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public User convertToEntityLogin(LoginFormDTO loginFormDTO) {
        return modelMapper.map(loginFormDTO, User.class);
    }

    public User convertToEntityRegister(RegisterFormDTO registerFormDTO) {
        return modelMapper.map(registerFormDTO, User.class);
    }

    public void login() {
        //Implementacija kasnije
    }

    public void register() {
        // Kasnije
    }


    public boolean isValidUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        // Assuming password is hashed and needs verification
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }

        return false;
    }
}

