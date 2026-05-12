package br.insper.sistemaprojetos.User;

import br.insper.sistemaprojetos.Papel;

import java.util.UUID;

import br.insper.sistemaprojetos.User.dto.EditUserDTO;
import br.insper.sistemaprojetos.User.dto.ResponseUserDTO;
import br.insper.sistemaprojetos.User.dto.SaveUserDTO;
import br.insper.sistemaprojetos.User.exception.UserAlreadyExistsException;
import br.insper.sistemaprojetos.User.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseUserDTO save(SaveUserDTO saveUserDTO) {

        if (userRepository.existsByCpf(saveUserDTO.getCpf())) {
            throw new UserAlreadyExistsException();
        }

        User user = User.toModel(saveUserDTO);
        user = userRepository.save(user);
        return ResponseUserDTO.toDTO(user);

    }

    public List<ResponseUserDTO> list(String nome, Papel papel) {
        List<User> users;
        if (nome != null) {
            users = userRepository.findByNomeContaining(nome);
        } else if (papel != null) {
            users = userRepository.findByPapel(papel);
        } else {
            users = userRepository.findAll();
        }

        return users.stream().map(ResponseUserDTO::toDTO).toList();
    }

    public User get(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public ResponseUserDTO getDTO(UUID id) {
        return ResponseUserDTO.toDTO(get(id));
    }

    public ResponseUserDTO edit(UUID id, EditUserDTO editUserDTO) {

        User userDB = get(id);
        userDB.setNome(editUserDTO.getNome());
        userDB.setCpf(editUserDTO.getCpf());
        userDB.setPapel(editUserDTO.getPapel());
        userDB = userRepository.save(userDB);

        return ResponseUserDTO.toDTO(userDB);

    }

    public void delete(UUID id) {
        User userDB = get(id);
        userRepository.delete(userDB);
    }

}
