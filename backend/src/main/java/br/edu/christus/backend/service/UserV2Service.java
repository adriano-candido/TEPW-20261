package br.edu.christus.backend.service;

import br.edu.christus.backend.domain.dto.UserDTO;
import br.edu.christus.backend.domain.model.User;
import br.edu.christus.backend.repository.UserRepository;
import br.edu.christus.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserV2Service {

    @Autowired
    private UserRepository repository;

    public User save(User user){
        if(user.getName().length() < 10){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O nome precisa ter ao menos 10 caracteres");
        }

        if(user.getName().length() > 150){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é permitido nomes com mais de 150 caracteres");
        }

        boolean emailExists;

        if(user.getId() == null){
            emailExists = repository.existsByEmail(user.getEmail());
        }else{
            emailExists = repository.existsByEmailAndIdNot(user.getEmail(),
                    user.getId());
        }

        if (emailExists){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Este e-mail já está sendo utilizado");
        }

        var userSaved = repository.save(user);

        return userSaved;
    }

}
