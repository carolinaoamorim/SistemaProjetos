package br.insper.sistemaprojetos.User.dto;

import br.insper.sistemaprojetos.Papel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveUserDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @NotNull(message = "O papel é obrigatório")
    private Papel papel;

}
