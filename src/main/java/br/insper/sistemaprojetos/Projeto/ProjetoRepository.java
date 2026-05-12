package br.insper.sistemaprojetos.Projeto;

import br.insper.sistemaprojetos.Projeto.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {

    boolean existsByNome(String nome);
    List<Projeto> findByNomeContaining(String nome);

}
