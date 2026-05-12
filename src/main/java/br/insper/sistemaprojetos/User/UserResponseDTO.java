package br.insper.sistemaprojetos.User;

import br.insper.sistemaprojetos.Papel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDTO {

    private UIUD id;
    private String nome;
    private String cpf;
    private Papel papel;

}
