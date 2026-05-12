package br.insper.sistemaprojetos.Projeto.dto;

import br.insper.sistemaprojetos.Projeto.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ResponseProjetoDTO {

    private UUID id;
    private String nome;
    private String descricao;

    public static ResponseProjetoDTO toDTO(Projeto projeto) {
        return new ResponseProjetoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao());
    }

}
