package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.util.Scanner;

public class IncluirPessoas {

    private  Scanner sc;
    private  PessoaFisicaRepo pessoa;
    private PessoaJuridicaRepo empresa;

    public IncluirPessoas(Scanner sc) {
        this.sc = sc;
        addPessoa();
    }

    private void addPessoa(){
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String tipoPessoa = sc.next().toLowerCase();

        do {
            if (tipoPessoa.equals("f")) {
                System.out.println("Digite o id da pessoa: ");
                int idPessoa = sc.nextInt();
                sc.nextLine(); // Limpar o buffer

                System.out.println("Insira os dados... ");
                System.out.print("Nome: ");
                String nomePessoa = sc.nextLine();

                System.out.print("Idade: ");
                int idadePessoa = sc.nextInt();
                sc.nextLine(); // Limpar o buffer

                System.out.print("Cpf: ");
                String cpfPessoa = sc.next();

                this.pessoa = new PessoaFisicaRepo();
                if (pessoa.inserir(new PessoaFisica(idPessoa, nomePessoa, cpfPessoa, idadePessoa))) {
                    System.out.println(nomePessoa + " foi Adicionado! Id: " + idPessoa);
                    tipoPessoa = "null";
                }
            } else if (tipoPessoa.equals("j")) {
                System.out.println("Digite o id da Empresa: ");
                int idEmpresa = sc.nextInt();
                sc.nextLine(); // Limpar o buffer

                System.out.println("Insira os dados... ");
                System.out.print("Nome: ");
                String nomeEmpresa = sc.nextLine();

                System.out.print("CNPJ: ");
                String cnpjEmpresa = sc.next();

                this.empresa = new PessoaJuridicaRepo();
                if (empresa.inserir(new PessoaJuridica(idEmpresa, nomeEmpresa, cnpjEmpresa))) {
                    System.out.println(nomeEmpresa + " foi Adicionado! Id: " + idEmpresa);
                    tipoPessoa = "null";
                }
            }
        }while ((tipoPessoa.equals("f") || tipoPessoa.equals("j")));
    }
}
