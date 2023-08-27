package application;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 =  new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1,"Andre","78844554",34));
        repo1.inserir(new PessoaFisica(3, "Milena", "987654321", 23));

        // Salvando os dados
        try {
            repo1.persistir("pessoasFisicas.dat");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }

        //aki fez a recuperaçao
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar("pessoasFisicas.dat");
        } catch (IOException | ClassNotFoundException erro) {
            System.out.println("Erro ao recuperar os dados: " + erro.getMessage());
        }

        // Recuperando a lista das pessoas
        List<PessoaFisica> pessoasFisicasLista = repo2.obterTodos();
        for (PessoaFisica pessoa : pessoasFisicasLista) {
            pessoa.exibir();
            System.out.println("<<<-------------------------->>>");
        }

        // Pessoas Jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(1, "Empresa A", "123456789"));
        repo3.inserir(new PessoaJuridica(2, "Empresa B", "987654321"));


        try {
            repo3.persistir("pessoasJuridicas.dat");
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar("pessoasJuridicas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }

        // Exibir os dados
        List<PessoaJuridica> pessoasJuridicasList = repo4.obterTodos();
        for (PessoaJuridica pessoa : pessoasJuridicasList) {
            pessoa.exibir();
            System.out.println("<<<-------------------------->>>");
        }
    }

    }

