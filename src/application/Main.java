package application;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("======================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("======================");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                        IncluirPessoas incluirpessoas = new IncluirPessoas(sc);
                    break;
                case 2:
                    // Código para alterar pessoa
                    break;
                case 3:
                    // Código para excluir pessoa
                    break;
                case 4:
                    // Código para buscar pelo Id
                    break;
                case 5:
                    // Código para exibir todos
                    break;
                case 6:
                    // Código para persistir dados
                    break;
                case 7:
                    // Código para recuperar dados
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}