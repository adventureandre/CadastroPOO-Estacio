package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.util.Scanner;

public class AlterarPessoa {
    private Scanner sc;
    private PessoaFisicaRepo pessoa;
    private PessoaJuridicaRepo empresa;

    public AlterarPessoa(Scanner sc, PessoaFisicaRepo pessoa, PessoaJuridicaRepo empresa) {
        this.sc = sc;
        this.pessoa = pessoa;
        this.empresa = empresa;
        alterarPessoa();
    }

    private int lerNumeroInteiro() {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Por favor, digite um número válido: ");
                sc.next();
            }
        }

        return numero;
    }

    private void alterarPessoa() {
        System.out.println("====ALTERAR====");
        String tipoPessoa;

        do {
            System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
            tipoPessoa = sc.next().toLowerCase();
        } while (!tipoPessoa.equals("f") && !tipoPessoa.equals("j"));


        do {
            if (tipoPessoa.equals("f")) {
                System.out.println("Digite o id da pessoa: ");
                int idPessoa = lerNumeroInteiro();
                sc.nextLine();

                System.out.println("Insira os Novos dados... ");
                System.out.print("Nome: ");
                String nomePessoa = sc.nextLine();

                System.out.print("Idade: ");
                int idadePessoa = lerNumeroInteiro();
                sc.nextLine();

                System.out.print("Cpf: ");
                String cpfPessoa = sc.next();

                PessoaFisica pessoaantiga = pessoa.obter(idPessoa);

                if (this.pessoa.alterar(this.pessoa.obter(idPessoa),
                        (new PessoaFisica(idPessoa, nomePessoa, cpfPessoa, idadePessoa)))) {
                    System.out.println("Dados de " + pessoaantiga.getNome() + " foi alterados com Sucesso!");
                    tipoPessoa = "null";
                }

                System.out.println("Erro id nao existe!");
                tipoPessoa = "null";


            } else if (tipoPessoa.equals("j")) {
                System.out.println("Digite o id da Empresa: ");
                int idEmpresa = lerNumeroInteiro();
                sc.nextLine(); // Limpar o buffer

                System.out.println("Insira os Novos dados... ");
                System.out.print("Nome: ");
                String nomeEmpresa = sc.nextLine();

                System.out.print("CNPJ: ");
                String cnpjEmpresa = sc.next();

                this.empresa.alterar(this.empresa.obter(idEmpresa), (new PessoaJuridica(idEmpresa, nomeEmpresa, cnpjEmpresa)));
                System.out.println("Dados alterados com Sucesso!");
                tipoPessoa = "null";
            }
        } while ((tipoPessoa.equals("f") || tipoPessoa.equals("j")));
    }
}
