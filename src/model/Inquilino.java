package model;

public class Inquilino extends Pessoa {
    private Imovel imovelAlugado;

    public Inquilino(String cpf, String nome, String telefone){
        super(cpf, nome, telefone);
    }

    public Imovel getImovelAlugado() {
        return imovelAlugado;
    }

    public void alugarImovel(Imovel imovel) {
        this.imovelAlugado = imovel;
        imovel.setAlugado(true);
    }

    public void desocuparImovel() {
        if (this.imovelAlugado != null) {
            this.imovelAlugado.setAlugado(false);
            this.imovelAlugado = null;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - CPF: " + cpf + " - Telefone: " + telefone + " Imovel alugado: " + imovelAlugado;
    }
}
