import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Imovel> imoveis = new ArrayList<>();
        List<Proprietario> proprietarios = new ArrayList<>();
        List<Inquilino> inquilinos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== SISTEMA IMOBILIÁRIO ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Alugar");
            System.out.println("4. Remover");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("1. Cadastrar Proprietário");
                    System.out.println("2. Cadastrar Casa");
                    System.out.println("3. Cadastrar Apartamento");
                    System.out.println("4. Voltar");
                    int cad = sc.nextInt();
                    sc.nextLine();

                    switch (cad) {

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
                        sc.nextLine();

                        Imovel novoImovel;
                        if (idx < 0 || idx >= proprietarios.size()) {
                            System.out.println("Índice inválido!");
                            break;
                        }

                        if (cad == 2) {
                            novoImovel = new Casa(end, num, proprietarios.get(idx), valor);
                        } else {
                            novoImovel = new Apartamento(end, num, proprietarios.get(idx), valor);
                        }

                        imoveis.add(novoImovel);
                        proprietarios.get(idx).adicionarImovel(novoImovel);
                        System.out.println("Imóvel cadastrado com sucesso!");
                        break;

                        case 4:
                            break;
                    }
                    break;

                case 2:
                    System.out.println("1. Listar Proprietários");
                    System.out.println("2. Listar Inquilinos");
                    System.out.println("3. Listar Imóveis");
                    System.out.println("4. Voltar");
                    int list = sc.nextInt();
                    sc.nextLine();

                    switch (list) {
                        case 1:
                            if (proprietarios.isEmpty()) System.out.println("Nenhum proprietário cadastrado.");
                            else proprietarios.forEach(System.out::println);
                            break;
                        case 2:
                            if (inquilinos.isEmpty()) System.out.println("Nenhum inquilino cadastrado.");
                            else inquilinos.forEach(System.out::println);
                            break;
                        case 3:
                            if (imoveis.isEmpty()) System.out.println("Nenhum imóvel cadastrado.");
                            else imoveis.forEach(System.out::println);
                            break;
                    }
                    break;

                case 3:
                    System.out.println("1. Alugar imóvel");
                    System.out.println("2. Calcular aluguel");
                    System.out.println("3. Voltar");
                    int alugar = sc.nextInt();
                    sc.nextLine();

                    if (alugar == 1) {
                        if (imoveis.isEmpty()) { System.out.println("Cadastre imóveis antes de alugar."); break; }

                        System.out.print("Nome do inquilino: ");
                        String nomeInq = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telInq = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpfInq = sc.nextLine();
                        Inquilino inq = new Inquilino(cpfInq, nomeInq, telInq);

                        System.out.println("Escolha o imóvel para alugar:");
                        for (int i = 0; i < imoveis.size(); i++) System.out.println(i + " - " + imoveis.get(i));
                        int idxImovel = sc.nextInt();
                        sc.nextLine();

                        Imovel imovel = imoveis.get(idxImovel);

                        if (idxImovel < 0 || idxImovel >= imoveis.size()) {
                            System.out.println("Índice inválido!");
                            break;
                        }

                        if (imovel.isAlugado()) System.out.println("Esse imóvel já está alugado!");
                        else {
                            inq.alugarImovel(imovel);
                            inquilinos.add(inq);
                            System.out.println("Imóvel alugado com sucesso!");
                        }

                    } else {
                        if (imoveis.isEmpty()) { System.out.println("Nenhum imóvel cadastrado."); break; }

                        System.out.println("Escolha o imóvel:");
                        for (int i = 0; i < imoveis.size(); i++) System.out.println(i + " - " + imoveis.get(i));
                        int idxCalc = sc.nextInt();
                        System.out.print("Desconto de 5% para apartamentos, na quantidade acima de 12 meses.");
                        System.out.print("Por quantos meses? ");
                        int meses = sc.nextInt();
                        sc.nextLine();

                        if (idxCalc < 0 || idxCalc >= imoveis.size()) {
                            System.out.println("Índice inválido!");
                            break;
                        }

                        double total = imoveis.get(idxCalc).calcularAluguel(meses);
                        System.out.println("Valor total: R$ " + total);
                    }
                    break;

                case 4:
                    System.out.println("1. Remover Proprietário");
                    System.out.println("2. Remover Imóvel");
                    System.out.println("3. Despejar Inquilino");
                    System.out.println("4. Voltar");
                    int rem = sc.nextInt();
                    sc.nextLine();

                    switch (rem) {
                        case 1:
                            if (proprietarios.isEmpty()) { System.out.println("Nenhum proprietário cadastrado."); break; }
                            for (int i = 0; i < proprietarios.size(); i++) System.out.println(i + " - " + proprietarios.get(i));
                            int idxPropRem = sc.nextInt(); sc.nextLine();

                            if (idxPropRem < 0 || idxPropRem >= proprietarios.size()) {
                                System.out.println("Índice inválido!");
                                break;
                            }

                            Proprietario prop = proprietarios.get(idxPropRem);

                            for (Imovel imovel : new ArrayList<>(prop.getImoveis())) {
                                inquilinos.removeIf(inq -> inq.getImovelAlugado() == imovel);
                                imoveis.remove(imovel);
                            }
                            proprietarios.remove(prop);
                            System.out.println("Proprietário e seus imóveis removidos com sucesso!");

                        case 2 :
                            if (imoveis.isEmpty()) { System.out.println("Nenhum imóvel cadastrado."); break; }
                            for (int i = 0; i < imoveis.size(); i++) System.out.println(i + " - " + imoveis.get(i));
                            int idxImRem = sc.nextInt(); sc.nextLine();

                            if (idxImRem < 0 || idxImRem >= imoveis.size()) {
                                System.out.println("Índice inválido!");
                                break;
                            }

                            Imovel imovelRemovido = imoveis.get(idxImRem);

                            inquilinos.removeIf(inq -> {
                                if (inq.getImovelAlugado() == imovelRemovido) {
                                    return true;
                                }
                                return false;
                            });

                            imovelRemovido.proprietario.removerImovel(imovelRemovido);
                            imoveis.remove(imovelRemovido);
                            System.out.println("Imóvel removido com sucesso!");

                        case 3:
                            if (inquilinos.isEmpty()) {
                                System.out.println("Nenhum inquilino cadastrado.");
                                break;
                            }

                            System.out.println("Escolha o inquilino para despejar:");
                            for (int i = 0; i < inquilinos.size(); i++) {
                                Inquilino inq = inquilinos.get(i);
                                String status = (inq.getImovelAlugado() != null) ?
                                        "Alugando: " + inq.getImovelAlugado() :
                                        "Sem imóvel";
                                System.out.println(i + " - " + inq.getNome() + " (" + status + ")");
                            }

                            int idxInqRem = sc.nextInt();
                            sc.nextLine();

                            if (idxInqRem < 0 || idxInqRem >= inquilinos.size()) {
                                System.out.println("Índice inválido!");
                                break;
                            }

                            Inquilino inqRemovido = inquilinos.get(idxInqRem);
                            inqRemovido.desocuparImovel();

                            inquilinos.remove(inqRemovido);
                            System.out.println("Inquilino despejado com sucesso!");
                            break;

                        case 4:
                            break;
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}