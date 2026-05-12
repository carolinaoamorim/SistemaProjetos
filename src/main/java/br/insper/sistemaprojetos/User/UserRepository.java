package br.insper.sistemaprojetos.User;

import br.insper.sistemaprojetos.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User, UIUD> {

    boolean existsByCpf(String cpf);
    Page<User> findByNomeContaining(String nome, Pageable pageable);
    Page<User> findByPapel(Papel papel, Pageable pageable);

}
