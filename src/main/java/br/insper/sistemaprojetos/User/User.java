package br.insper.sistemaprojetos.User;

import br.insper.sistemaprojetos.Papel;
import br.insper.sistemaprojetos.Projeto.Projeto;
import br.insper.sistemaprojetos.User.dto.SaveUserDTO;
import jakarta.persistence.*;
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
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Papel papel;

    @ManyToMany(mappedBy="usuarios")
    private List<Projeto> projetos = new ArrayList<>();

    public static User toModel(SaveUserDTO dto) {
        User user = new User();
        user.setNome(dto.getNome());
        user.setCpf(dto.getCpf());
        user.setPapel(dto.getPapel());
        return user;
    }

}
