package br.insper.sistemaprojetos.Projeto.exception;

public class ProjetoNotFoundException extends RuntimeException{

    public ProjetoNotFoundException() {
        super("Projeto não encontrado");
    }
}
