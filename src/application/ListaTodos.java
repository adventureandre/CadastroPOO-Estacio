package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.util.List;
import java.util.Scanner;

public class ListaTodos {

    private Scanner sc;
    private PessoaFisicaRepo pessoa;
    private PessoaJuridicaRepo empresa;

    public ListaTodos(Scanner sc, PessoaFisicaRepo pessoa, PessoaJuridicaRepo empresa) {
        this.sc = sc;
        this.pessoa = pessoa;
        this.empresa = empresa;
        getLista();
    }

    public void getLista() {
        System.out.println("====Lista====");
        String tipoPessoa;
        do {
            System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
            tipoPessoa = sc.next().toLowerCase();
        } while (!tipoPessoa.equals("f") && !tipoPessoa.equals("j"));

        do {
            if (tipoPessoa.equals("f")) {
                List<PessoaFisica> pessoasFisicasLista = pessoa.obterTodos();
                if (pessoasFisicasLista.isEmpty()) {
                    System.out.println("Lista de pessoas físicas vazia.");
                } else {
                    for (PessoaFisica pessoa : pessoasFisicasLista) {
                        pessoa.exibir();
                        System.out.println("<<<-------------------------->>>");
                    }
                }
                tipoPessoa = "null";

            } else if (tipoPessoa.equals("j")) {
                List<PessoaJuridica> pessoasJuridicaLista = empresa.obterTodos();
                if (pessoasJuridicaLista.isEmpty()) {
                    System.out.println("Lista de pessoas jurídicas vazia.");
                } else {
                    for (PessoaJuridica pessoa : pessoasJuridicaLista) {
                        pessoa.exibir();
                        System.out.println("<<<-------------------------->>>");
                    }
                }
                tipoPessoa = "null";

            }
        } while ((tipoPessoa.equals("f") || tipoPessoa.equals("j")));
    }
}
