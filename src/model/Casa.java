package model;

public class Casa extends Imovel {
    public double valorMensalidade;

    public Casa(String endereco, int numero, Proprietario proprietario, double valorMensalidade) {
        super(endereco, numero, proprietario);
        this.valorMensalidade = valorMensalidade;
    }

    @Override
    public String estaAlugado() {
        String mensagem = "A casa está disponível";
        if (alugado) {
            mensagem = "A casa está alugada";
        }
        return mensagem;
    }

    @Override
    public double calcularAluguel(int quantidadeMeses) {
        return valorMensalidade * quantidadeMeses;
    }

    @Override
    public String toString() {
        return "Casa nº " + numero + " - Endereço: " + endereco + estaAlugado() + contatoProprietario();
    }
}
