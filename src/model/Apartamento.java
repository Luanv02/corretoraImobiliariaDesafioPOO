package model;

public class Apartamento extends Imovel{
    public double valorMensalidade = 1000.00;

    public Apartamento(String endereco, int numero, Proprietario proprietario) {
        super(endereco, numero, proprietario);
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
}
