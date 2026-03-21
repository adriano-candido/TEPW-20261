package br.edu.christus.backend.controller;

import br.edu.christus.backend.domain.model.User;
import br.edu.christus.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User create(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable(name = "id") Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
