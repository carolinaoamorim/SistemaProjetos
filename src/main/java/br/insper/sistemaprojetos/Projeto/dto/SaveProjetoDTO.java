package br.insper.sistemaprojetos.Projeto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveProjetoDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

}
