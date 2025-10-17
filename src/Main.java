import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Imovel> imoveis = new ArrayList<>();
        List<Proprietario> proprietarios = new ArrayList<>();
        List<Inquilino> inquilinos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== SISTEMA IMOBILIÁRIO ===");
            System.out.println("1. Cadastrar Proprietário");
            System.out.println("2. Cadastrar Casa");
            System.out.println("3. Cadastrar Apartamento");
            System.out.println("4. Listar Proprietários");
            System.out.println("5. Listar Inquilinos");
            System.out.println("6. Listar Imóveis");
            System.out.println("7. Alugar Imóvel");
            System.out.println("8. Calcular Aluguel");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String tel = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    proprietarios.add(new Proprietario(cpf, nome, tel));
                    System.out.println("Proprietário cadastrado com sucesso!");
                    break;

                case 2:
                case 3:
                    if (proprietarios.isEmpty()) {
                        System.out.println("Cadastre um proprietário primeiro!");
                        break;
                    }

                    System.out.print("Endereço: ");
                    String end = sc.nextLine();
                    System.out.print("Número: ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escolha o proprietário (índice):");
                    for (int i = 0; i < proprietarios.size(); i++) {
                        System.out.println(i + " - " + proprietarios.get(i).getNome());
                    }
                    int idx = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Valor mensal: ");
                    double valor = sc.nextDouble();

                    Imovel novoImovel;
                    if (opcao == 2) {
                        novoImovel = new Casa(end, num, proprietarios.get(idx), valor);
                    } else {
                        novoImovel = new Apartamento(end, num, proprietarios.get(idx), valor);
                    }

                    imoveis.add(novoImovel);
                    proprietarios.get(idx).adicionarImovel(novoImovel);
                    System.out.println("Imóvel cadastrado com sucesso!");
                    break;

                case 4:
                    if (proprietarios.isEmpty()) {
                        System.out.println("Nenhum proprietário cadastrado.");
                    } else {
                        for (Proprietario i : proprietarios) {
                            System.out.println(i);
                        }
                    }
                    break;

                case 5:
                    if (inquilinos.isEmpty()) {
                        System.out.println("Nenhum Inquilino cadastrado.");
                    } else {
                        for (Inquilino i : inquilinos) {
                            System.out.println(i);
                        }
                    }
                    break;

                case 6:
                    if (imoveis.isEmpty()) {
                        System.out.println("Nenhum imóvel cadastrado.");
                    } else {
                        for (Imovel i : imoveis) {
                            System.out.println(i);
                        }
                    }
                    break;

                case 7:
                    if (imoveis.isEmpty()) {
                        System.out.println("Cadastre imóveis antes de alugar.");
                        break;
                    }

                    System.out.print("Nome do inquilino: ");
                    String nomeInq = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telInq = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfInq = sc.nextLine();
                    Inquilino inq = new Inquilino(cpfInq, nomeInq, telInq);
                    inquilinos.add(inq);

                    System.out.println("Escolha o imóvel para alugar:");
                    for (int i = 0; i < imoveis.size(); i++) {
                        System.out.println(i + " - " + imoveis.get(i));
                    }
                    int idxImovel = sc.nextInt();
                    sc.nextLine();

                    Imovel imovel = imoveis.get(idxImovel);
                    if (imovel.isAlugado()) {
                        System.out.println("Esse imóvel já está alugado!");
                    } else {
                        inq.alugarImovel(imovel);
                        System.out.println("Imóvel alugado com sucesso!");
                    }
                    break;

                case 8:
                    System.out.println("Escolha o imóvel:");
                    for (int i = 0; i < imoveis.size(); i++) {
                        System.out.println(i + " - " + imoveis.get(i));
                    }
                    int idxCalc = sc.nextInt();
                    System.out.print("Por quantos meses? ");
                    int meses = sc.nextInt();

                    double total = imoveis.get(idxCalc).calcularAluguel(meses);
                    System.out.println("Valor total: R$ " + total);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}