package br.insper.sistemaprojetos.User;

import br.insper.sistemaprojetos.Papel;

import java.awt.print.Pageable;
import java.util.UUID;

import static java.lang.reflect.Array.get;

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

    public Page<ResponseUserDTO> list(String nome, Papel papel, Pageable pageable) {

        if (nome != null) {
            return userRepository.findByNomeContaining(nome, pageable).map(user -> ResponseUserDTO.toDTO(user));
        } else if (papel != null) {
            return userRepository.findByPapel(papel, pageable).map(user -> ResponseUserDTO.toDTO(user));
        }

        return userRepository.findAll(pageable).map(user -> ResponseUserDTO.toDTO(user));

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
