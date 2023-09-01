package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.util.List;
import java.util.Scanner;

public class BuscarPessoa {

    private Scanner sc;
    private PessoaFisicaRepo pessoa;
    private PessoaJuridicaRepo empresa;

    public BuscarPessoa(Scanner sc, PessoaFisicaRepo pessoa, PessoaJuridicaRepo empresa) {
        this.sc = sc;
        this.pessoa = pessoa;
        this.empresa = empresa;
        buscarPessoa();
    }

    public void buscarPessoa() {
        System.out.println("====Buscar====");
        String tipoPessoa;
        do {
            System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
            tipoPessoa = sc.next().toLowerCase();
        } while (!tipoPessoa.equals("f") && !tipoPessoa.equals("j"));


        do {
            if (tipoPessoa.equals("f")) {
                System.out.println("Digite o id da pessoa: ");
                int idPessoa = sc.nextInt();
                sc.nextLine();

                PessoaFisica getBuscaPessoa = pessoa.obter(idPessoa);
                if (getBuscaPessoa != null) {


                    System.out.println("Id: " + getBuscaPessoa.getId());
                    System.out.println("Nome: " + getBuscaPessoa.getNome());
                    System.out.println("CPF: " + getBuscaPessoa.getCpf());
                    System.out.println("Idade: " + getBuscaPessoa.getIdade());
                    System.out.println("-------------------------------");
                } else {
                    System.out.println("Pessoa não encontrada!");
                }
                tipoPessoa = "null";


            } else if (tipoPessoa.equals("j")) {
                System.out.println("Digite o id da Empresa: ");
                int idEmpresa = sc.nextInt();
                sc.nextLine();


                PessoaJuridica getBuscaPessoa = empresa.obter(idEmpresa);
                if (getBuscaPessoa != null) {
                    System.out.println("Id: " + getBuscaPessoa.getId());
                    System.out.println("Nome: " + getBuscaPessoa.getNome());
                    System.out.println("CNPJ: " + getBuscaPessoa.getCnpj());
                    System.out.println("-------------------------------");
                } else {
                    System.out.println("Empresa não encontrada!");
                }
                tipoPessoa = "null";
            }
        } while ((tipoPessoa.equals("f") || tipoPessoa.equals("j")));
    }
}