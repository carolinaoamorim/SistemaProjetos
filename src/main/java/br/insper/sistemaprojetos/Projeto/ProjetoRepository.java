package br.insper.sistemaprojetos.Projeto;

import br.insper.sistemaprojetos.Projeto.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projetos, Integer> {

}
