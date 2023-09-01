package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.util.List;
import java.util.Scanner;

public class IncluirPessoas {

    private  Scanner sc;
    private  PessoaFisicaRepo pessoa;
    private PessoaJuridicaRepo empresa;

    public IncluirPessoas(Scanner sc, PessoaFisicaRepo pessoa,PessoaJuridicaRepo empresa) {
        this.sc = sc;
        this.pessoa =  pessoa;
        this.empresa = empresa;
        addPessoa();
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

    private void addPessoa(){
        System.out.println("====INCLUIR====");
        String tipoPessoa;
        do {
            System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
            tipoPessoa = sc.next().toLowerCase();
        }while (!tipoPessoa.equals("f") && !tipoPessoa.equals("j"));


        do {
            if (tipoPessoa.equals("f")) {
                System.out.println("Digite o id da pessoa: ");
                int idPessoa = lerNumeroInteiro();
                sc.nextLine(); // Limpar o buffer

                System.out.println("Insira os dados... ");
                System.out.print("Nome: ");
                String nomePessoa = sc.nextLine();

                System.out.print("Idade: ");
                int idadePessoa = lerNumeroInteiro();
                sc.nextLine(); // Limpar o buffer

                System.out.print("Cpf: ");
                String cpfPessoa = sc.next();

                if (pessoa.inserir(new PessoaFisica(idPessoa, nomePessoa, cpfPessoa, idadePessoa))) {
                    System.out.println(nomePessoa + " foi Adicionado! Id: " + idPessoa);
                    tipoPessoa = "null";
                }else{
                    System.out.println("Essa pessoa já existe!");
                    tipoPessoa = "null";
                }

            } else if (tipoPessoa.equals("j")) {
                System.out.println("Digite o id da Empresa: ");
                int idEmpresa = lerNumeroInteiro();
                sc.nextLine(); // Limpar o buffer

                System.out.println("Insira os dados... ");
                System.out.print("Nome: ");
                String nomeEmpresa = sc.nextLine();

                System.out.print("CNPJ: ");
                String cnpjEmpresa = sc.next();

                if (empresa.inserir(new PessoaJuridica(idEmpresa, nomeEmpresa, cnpjEmpresa))) {
                    System.out.println(nomeEmpresa + " foi Adicionado! Id: " + idEmpresa);
                    tipoPessoa = "null";
                }
            }
        }while ((tipoPessoa.equals("f") || tipoPessoa.equals("j")));
    }
}
