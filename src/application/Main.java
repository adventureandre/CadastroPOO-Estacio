package application;

import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int opcao;
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();
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
//Adicionar Pessoas Juridica e Fisica
                    IncluirPessoas incluirpessoas = new IncluirPessoas(sc, repo1, repo2);
                    break;
                case 2:
                    AlterarPessoa alterarPessoa = new AlterarPessoa(sc, repo1, repo2);
                    break;
                case 3:
                    ExcluirPessoas excluirPessoas = new ExcluirPessoas(sc, repo1, repo2);
                    break;
                case 4:
                    BuscarPessoa buscarPessoa = new BuscarPessoa(sc, repo1, repo2);
                    break;
                case 5:
                    ListaTodos listaTodos = new ListaTodos(sc, repo1, repo2);
                    break;
                case 6:
                    System.out.println("====Dados Salvos====");
                    try {
                        repo1.persistir("pessoasFisicas.dat");
                        repo2.persistir("pessoasJuridicas.dat");

                    } catch (IOException erro) {
                        System.out.println("Erro ao recuperar os dados: " + erro.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("====Dados Recuperados====");
                    try {
                        repo1.recuperar("pessoasFisicas.dat");
                        repo2.recuperar("pessoasJuridicas.dat");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        }
        while (opcao != 0);
        sc.close();
    }
}