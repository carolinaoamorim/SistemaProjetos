package br.insper.sistemaprojetos.Projeto;

import br.insper.sistemaprojetos.Projeto.dto.SaveProjetoDTO;
import br.insper.sistemaprojetos.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(name = "projeto_usuario",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<User> usuarios = new ArrayList();

    public static Projeto toModel(SaveProjetoDTO dto) {
        Projeto projeto = new Projeto();
        projeto.setNome(dto.getNome());
        projeto.setDescricao(dto.getDescricao());

        return projeto;

    }

}
