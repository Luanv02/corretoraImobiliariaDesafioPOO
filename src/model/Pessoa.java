package model;

public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected String telefone;

    public Pessoa(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getTelefone(){
        return telefone;
    }
}
