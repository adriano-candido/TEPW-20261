package br.edu.christus.backend.controller;

import br.edu.christus.backend.domain.dto.UserDTO;
import br.edu.christus.backend.domain.dto.UserLowDTO;
import br.edu.christus.backend.domain.model.User;
import br.edu.christus.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Cadastra os dados de um usuário | role: [ADMIN]", tags = "User")
    @PostMapping
    public UserLowDTO create(@RequestBody UserDTO user){
        return service.save(user);
    }

    @PutMapping
    public UserLowDTO update(@RequestBody UserDTO user){
        return service.save(user);
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Retorna os dados de um usuário | role: [ADMIN]", tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "object",
                                    example = """
            {
              "timestamp": "string",
              "status": 404,
              "error": "string",
              "message": "string",
              "path": "string"
            }
            """)
                    ))
    })
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable(name = "id") Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
