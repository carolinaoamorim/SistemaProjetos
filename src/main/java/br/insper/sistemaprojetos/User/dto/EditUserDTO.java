package br.insper.sistemaprojetos.User.dto;

import br.insper.sistemaprojetos.Papel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditUserDTO {

    private String nome;
    private String cpf;
    private Papel papel;

}
