package model;

public class Casa extends Imovel {
    public double valorMensalidade = 500.00;

    public Casa(String endereco, int numero, Proprietario proprietario) {
        super(endereco, numero, proprietario);
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
}
