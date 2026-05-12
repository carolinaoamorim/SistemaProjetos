package br.insper.sistemaprojetos.Projeto.exception;

public class ProjetoAlreadyExistsException extends RuntimeException{

    public ProjetoAlreadyExistsException() {
        super("Projeto já existe");
    }
}
