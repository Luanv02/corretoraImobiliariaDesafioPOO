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
            mensagem = "O apartamento de número " + numero + " está alugado";
        }
        return mensagem;
    }

    @Override
    public double calcularAluguel(int quantidadeMeses) {
        boolean desconto = aplicarDesconto(quantidadeMeses);
        if (desconto) {
            valorMensalidade = valorMensalidade * 0.95; // 5% de desconto para cada mes
        }
        return valorMensalidade * quantidadeMeses;
    }

    public boolean aplicarDesconto(int quantidadesMeses) {
        if (quantidadesMeses >= 12) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Apartamento nº " + numero + " - Endereço: " + endereco + " (" + estaAlugado() + ") " + contatoProprietario();
    }
}
