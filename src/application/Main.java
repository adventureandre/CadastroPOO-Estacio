package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("======================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("======================");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoPessoa = sc.next();
                    while (tipoPessoa.equals("F") || tipoPessoa.equals("f") || tipoPessoa.equals("J") || tipoPessoa.equals("j")) {
                        if (tipoPessoa.equals("F") || tipoPessoa.equals("f")) {
                            System.out.println("Digite o id da pessoa: ");
                            int idPessoa = sc.nextInt();

                            System.out.println("Insira os dados... ");

                            System.out.print("Nome: ");
                            sc.nextLine();
                            String nomePessoa = sc.nextLine();

                            System.out.print("Idade: ");
                            int idadePessoa = sc.nextInt();

                            System.out.print("Cpf: ");
                            sc.nextLine();
                            String cpfPessoa = sc.next();

                            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
                            if (repo1.inserir(new PessoaFisica(idPessoa, nomePessoa, cpfPessoa, idadePessoa))) {
                                System.out.println(nomePessoa + " foi Adiocionado! Id: " + idPessoa);
                            }

                        } else if (tipoPessoa.equals("J") || tipoPessoa.equals("j")) {
                            System.out.println("pessoa juridica");
                        }
                    }


                    break;
                case 2:
                    // Código para alterar pessoa
                    break;
                case 3:
                    // Código para excluir pessoa
                    break;
                case 4:
                    // Código para buscar pelo Id
                    break;
                case 5:
                    // Código para exibir todos
                    break;
                case 6:
                    // Código para persistir dados
                    break;
                case 7:
                    // Código para recuperar dados
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}