package br.insper.sistemaprojetos.error;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        super("Acesso negado");
    }
}