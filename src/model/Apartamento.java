package model;

public class Apartamento extends Imovel{
    public double valorMensalidade;

    public Apartamento(String endereco, int numero, Proprietario proprietario, double valorMensalidade) {
        super(endereco, numero, proprietario);
        this.valorMensalidade = valorMensalidade;
    }

    @Override
    public String estaAlugado() {
        String mensagem = "O apartamento de número " + numero + " está disponível";
        if (alugado) {
            mensagem = "O apartamento de número " + numero + "está alugado";
        }
        return mensagem;
    }

    @Override
    public double calcularAluguel(int quantidadeMeses) {
        return valorMensalidade * quantidadeMeses;
    }

    @Override
    public String toString() {
        return "Apartamento nº " + numero + " - Endereço: " + endereco + estaAlugado() + contatoProprietario();
    }
}
