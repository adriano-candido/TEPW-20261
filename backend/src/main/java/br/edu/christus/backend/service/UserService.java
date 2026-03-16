package br.edu.christus.backend.service;

import br.edu.christus.backend.domain.User;
import br.edu.christus.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user){
        if(user.getName().length() > 150){
            System.out.println("Não é permitido nomes com mais de 50 caracteres");
            return null;
        }

        var userSaved = repository.save(user);

        return userSaved;
    }

}
