package model.gerenciadores;

import model.entidades.PessoaFisica;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public boolean inserir(PessoaFisica pessoaFisica) {
       return pessoasFisicas.add(pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisicaAntiga, PessoaFisica pessoaFisicaNova) {
        int index = pessoasFisicas.indexOf(pessoaFisicaAntiga);
        if (index != -1) {
            pessoasFisicas.set(index, pessoaFisicaNova);
        }
    }

    public void excluir(int id) {
        PessoaFisica pessoaExcluir = obter(id);
        if (pessoaExcluir != null) {
            pessoasFisicas.remove(pessoaExcluir);
            System.out.println("Entidade com ID " + id + " excluída com sucesso.");
        } else {
            System.out.println("Entidade com ID " + id + " não encontrada.");
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : pessoasFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoasFisicas);
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasFisicas);
            System.out.println("Dados de Pessoa Fisica Armazenados.");
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) inputStream.readObject();
            System.out.println("Dados de Pessoa Fisica Recuperados.");
        }
    }
}
