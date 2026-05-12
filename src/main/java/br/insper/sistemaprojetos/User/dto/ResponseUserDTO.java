package br.insper.sistemaprojetos.User.dto;

import br.insper.sistemaprojetos.Papel;
import br.insper.sistemaprojetos.User.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ResponseUserDTO {
    private UUID id;
    private String nome;
    private String cpf;
    private Papel papel;

    public static ResponseUserDTO toDTO(User user) {
        return new ResponseUserDTO(
                user.getId(),
                user.getNome(),
                user.getCpf(),
                user.getPapel()
        );
    }

}