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

    private void alterarPessoa() {
        System.out.println("====ALTERAR====");
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String tipoPessoa = sc.next().toLowerCase();

        do {
            if (tipoPessoa.equals("f")) {
                System.out.println("Digite o id da pessoa: ");
                int idPessoa = sc.nextInt();
                sc.nextLine(); // Limpar o buffer

                System.out.println("Insira os Novos dados... ");
                System.out.print("Nome: ");
                String nomePessoa = sc.nextLine();

                System.out.print("Idade: ");
                int idadePessoa = sc.nextInt();
                sc.nextLine(); // Limpar o buffer

                System.out.print("Cpf: ");
                String cpfPessoa = sc.next();

                this.pessoa.alterar(this.pessoa.obter(idadePessoa), (new PessoaFisica(idPessoa, nomePessoa, cpfPessoa, idadePessoa)));

                System.out.println("Dados alterados com Sucesso!");
                tipoPessoa = "null";

            } else if (tipoPessoa.equals("j")) {
                System.out.println("Digite o id da Empresa: ");
                int idEmpresa = sc.nextInt();
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
