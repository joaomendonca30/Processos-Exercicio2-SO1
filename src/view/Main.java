package view;

import controller.KillController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KillController killController = new KillController();
        Scanner scanner = new Scanner(System.in);

        // Exibe opções de ação
        System.out.println("1 - Listar processos");
        System.out.println("2 - Matar processo por PID");
        System.out.println("3 - Matar processo por nome");
        System.out.println("Digite a opção desejada:");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                killController.listaProcessos();
                break;
            case 2:
                System.out.println("Digite o PID do processo a ser morto:");
                int pid = scanner.nextInt();
                killController.mataPid(pid);
                break;
            case 3:
                System.out.println("Digite o nome do processo a ser morto:");
                scanner.nextLine(); // Limpar o buffer
                String nomeProcesso = scanner.nextLine();
                killController.mataNome(nomeProcesso);
                break;
            default:
                System.out.println("Opção inválida");
        }

        scanner.close();
    }
}