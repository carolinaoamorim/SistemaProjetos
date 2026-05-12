package br.insper.sistemaprojetos.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O cpf é obrigatório")
    private String cpf;

    @NotNull(message = "O papel é obrigatório")
    private String papel;

}
