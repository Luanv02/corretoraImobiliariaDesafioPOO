package model;

public abstract class Imovel {
    protected String endereco;
    protected int numero;
    protected boolean alugado;
    protected Proprietario proprietario;

    public Imovel(String endereco, int numero, boolean alugado, Proprietario proprietario){
        this.endereco = endereco;
        this.numero = numero;
        this.alugado = false;
        this.proprietario = proprietario;
    }

    //getters e setters

    public boolean isAlugado() {
        return this.alugado;
    }

    public String contatoProprietario() {
        String NomeProprietario = this.proprietario.getNome();
        String telefoneProprietario = this.proprietario.getTelefone();

        return String.format("Contato do telefone do proprietário %s é: $s", NomeProprietario, telefoneProprietario);
    }

    public abstract String estaAlugado();
    public abstract double aluguel();
}
