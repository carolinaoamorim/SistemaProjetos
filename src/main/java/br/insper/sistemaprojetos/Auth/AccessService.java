package br.insper.sistemaprojetos.Auth;

import br.insper.sistemaprojetos.Papel;
import br.insper.sistemaprojetos.User.User;
import br.insper.sistemaprojetos.User.UserRepository;
import br.insper.sistemaprojetos.User.exception.UserNotFoundException;
import br.insper.sistemaprojetos.error.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccessService {

    @Autowired
    private UserRepository userRepository;

    public User getUserFromHeader(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
    }

    public void checkAdmin(UUID userId) {

        User user = getUserFromHeader(userId);
        if (user.getPapel() != Papel.ADMIN) {
            throw new ForbiddenException();
        }
    }
}
