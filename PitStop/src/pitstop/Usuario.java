package pitstop;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Usuario {

    static Scanner input = new Scanner(System.in);

    public static String menu() {
        // MENU INICIAL
        String op = "";

        try {

            System.out.println("1 - Entregar próximo ingresso");
            System.out.println("2 - Retirar pessoa da sala de cinema");
            System.out.println("3 - Inserir nova pessoa na fila");
            System.out.println("4 - Mostrar pessoas que já receberam ingressos");
            System.out.println("5 - Mostrar ingressos ainda disponíveis");
            System.out.println("6 - Mostrar quantidade de pessoas na fila");
            System.out.println("0 - Encerrar aplicação");
            System.out.print("Escolha uma opção: ");
            op = input.next();
            System.out.println("-----\n");

        } catch (NoSuchElementException e) {
            System.err.println("Valor inválido!\n");
            System.exit(1);
        }

        return op;
    }

    public static String[] cadastroPessoa() {
        // INTERAÇÃO COM O USUÁRIO, PARA CADASTRO DOS DADOS
        String[] dados = new String[3];

        input.nextLine();

        System.out.print("Digite seu nome (3 caracteres ou mais): ");
        String nome = input.nextLine();
        if (nome.length() >= 3){
            dados[0] = nome;
        } else {
            System.err.println("Valor Inválido!\n");
            return dados;
        }

        System.out.print("Digite seu celular(opcional): ");
        dados[1] = input.nextLine();

        System.out.print("Digite seu e-mail (5 caracteres ou mais): ");
        String email = input.nextLine();
        if (email.length() >= 5) {
            dados[2] = email;
        } else {
            System.err.println("Valor Inválido!\n");
            return dados;
        }

        return dados;
    }

    public static String removePessoa() {
        // INTERAÇÃO COM O USUÁRIO PARA SAÍDA DE ALGUMA SALA
        input.nextLine();

        System.out.print("Digite o código do ingresso, da pessoa que será removida da sala: ");
        String cod = input.nextLine();

        return cod;
    }
}
