package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;

import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;
import java.util.Scanner;

public class ExcluirPessoas {
    private Scanner sc;
    private PessoaFisicaRepo pessoa;
    private PessoaJuridicaRepo empresa;

    public ExcluirPessoas(Scanner sc, PessoaFisicaRepo pessoa, PessoaJuridicaRepo empresa) {
        this.sc = sc;
        this.pessoa = pessoa;
        this.empresa = empresa;

        excluirPessoa();
    }

    private void excluirPessoa(){
        System.out.println("====Excluir====");
        String tipoPessoa;
        do {
            System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
            tipoPessoa = sc.next().toLowerCase();
        }while (!tipoPessoa.equals("f") && !tipoPessoa.equals("j"));
        do {
            if (tipoPessoa.equals("f")) {
                System.out.println("Digite o id da pessoa: ");
                int idPessoa = sc.nextInt();
                sc.nextLine();
                pessoa.excluir(idPessoa);
                tipoPessoa = "null";
            } else if (tipoPessoa.equals("j")) {
                System.out.println("Digite o id da Empresa: ");
                int idEmpresa = sc.nextInt();
                sc.nextLine();
                empresa.excluir(idEmpresa);
                tipoPessoa = "null";
            }
        }while ((tipoPessoa.equals("f") || tipoPessoa.equals("j"))); }}