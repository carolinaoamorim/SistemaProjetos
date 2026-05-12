package br.insper.sistemaprojetos.User;

import br.insper.sistemaprojetos.Papel;
import br.insper.sistemaprojetos.User.dto.EditUserDTO;
import br.insper.sistemaprojetos.User.dto.ResponseUserDTO;
import br.insper.sistemaprojetos.User.dto.SaveUserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<ResponseUserDTO> listUsers( @RequestParam(required = false, name = "nome") String nome,  @RequestParam(required = false, name = "papel") Papel papel) {
        return userService.list(nome, papel);
    }

    @PostMapping
    public ResponseUserDTO saveUser(@Valid @RequestBody SaveUserDTO user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public ResponseUserDTO getUser(@PathVariable UUID id) {
        return userService.getDTO(id);
    }

    @PutMapping("/{id}")
    public ResponseUserDTO editUser(@PathVariable UUID id, @RequestBody EditUserDTO user) {
        return userService.edit(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.delete(id);
    }

}
