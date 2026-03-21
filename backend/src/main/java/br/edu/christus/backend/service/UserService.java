package br.edu.christus.backend.service;

import br.edu.christus.backend.domain.model.User;
import br.edu.christus.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        var user = repository.findById(id);
        if(user.isEmpty()){
            System.out.println("Usuário com o id informado não existe");
            return null;
        }

        return user.get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
