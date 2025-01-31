package model.gerenciadores;

import model.entidades.PessoaJuridica;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    private List<PessoaJuridica> pessoasJuridicas;
    public PessoaJuridicaRepo() { pessoasJuridicas = new ArrayList<>();
    }

    public boolean inserir(PessoaJuridica pessoaJuridica) {
        return pessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridicaAntiga, PessoaJuridica pessoaJuridicaNova) {
        int index = pessoasJuridicas.indexOf(pessoaJuridicaAntiga);
        if (index != -1) { pessoasJuridicas.set(index, pessoaJuridicaNova);
        }
    }

    public void excluir(int id) { PessoaJuridica pessoaExcluir = obter(id);
        if (pessoaExcluir != null) { pessoasJuridicas.remove(pessoaExcluir); System.out.println("PessoaJuridica com Id " + id + " excluída com sucesso.");
        } else {
            System.out.println("PessoaJuridica com Id " + id + " não encontrada.");
        }
    }

    public PessoaJuridica obter(int id) { for (PessoaJuridica pessoa : pessoasJuridicas) {
        if (pessoa.getId() == id) { return pessoa;
        }
    }
        return null;
    }
    public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(pessoasJuridicas);
    }

    public void persistir(String nomeArquivo) throws IOException { try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
        outputStream.writeObject(pessoasJuridicas);
        System.out.println("Dados de Pessoa Juridica Armazenados.");
    }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) { pessoasJuridicas = (ArrayList<PessoaJuridica>) inputStream.readObject();
            System.out.println("Dados de Pessoa Juridica Recuperados.");
        }
    }
}