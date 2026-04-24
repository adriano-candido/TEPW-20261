package br.edu.christus.backend.controller;

import br.edu.christus.backend.domain.dto.UserDTO;
import br.edu.christus.backend.domain.model.User;
import br.edu.christus.backend.service.UserService;
import br.edu.christus.backend.service.UserV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/user")
public class UserV2Controller {

    @Autowired
    private UserV2Service service;

    @PostMapping
    public User create(@RequestBody User user){
        return service.save(user);
    }

}
