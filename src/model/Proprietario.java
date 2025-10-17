package model;

import java.util.ArrayList;
import java.util.List;

public class Proprietario extends Pessoa{
    private List<Imovel> imoveis;

    public Proprietario(String cpf, String nome, String telefone) {
        super(cpf, nome, telefone);
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel){
        imoveis.add(imovel);
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - CPF: " + cpf + " - Telefone: " + telefone;
    }
}
