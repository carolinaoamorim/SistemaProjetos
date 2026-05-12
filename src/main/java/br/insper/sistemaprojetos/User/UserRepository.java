package br.insper.sistemaprojetos.User;

import br.insper.sistemaprojetos.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByCpf(String cpf);
    List<User> findByNomeContaining(String nome);
    List<User> findByPapel(Papel papel);

}
