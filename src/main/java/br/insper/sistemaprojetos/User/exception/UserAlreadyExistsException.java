package br.insper.sistemaprojetos.User.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("O usuário já existe");
    }

}
