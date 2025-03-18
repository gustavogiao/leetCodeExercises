package Complementares;

import java.util.Random;
import java.util.Scanner;

public class AltoBaixo {
    public static void main(String[] args) {
        String i = "S";
        while (i.equals("S")) {
            Random random = new Random();
            int num = random.nextInt(100);
            int naosei = 101;
            int tentativas = 0;
            while (num != naosei) {
                Scanner sc = new Scanner(System.in);
                int tentativa = sc.nextInt();
                naosei = tentativa;
                if (tentativa > num) {
                    System.out.println("mais baixo");
                    tentativas += 1;
                } else if (tentativa < num) {
                    System.out.println("mais alto");
                    tentativas += 1;
                } else {
                    tentativas += 1;
                    System.out.format("acertaste!! só em %d tentativas 🙂 \n", tentativas);
                    int tentativasComputador = computadorJoga(num);
                    if (tentativas < tentativasComputador) {
                        System.out.println("Você ganhou!");
                    } else if (tentativas > tentativasComputador) {
                        System.out.println("O computador ganhou!");
                    } else {
                        System.out.println("Empate!");
                    }
                    System.out.println("Queres continuar? Prima (S)im");
                    String resposta = sc.nextLine();
                    i = resposta;
                }
            }
        }
    }

    public static int computadorJoga(int num) {
        Random random = new Random();
        int tentativaComputador;
        int tentativas = 0;
        int min = 0;
        int max = 100;
        do {
            tentativaComputador = random.nextInt(max - min) + min; // Isto basicamente, gera um número aleatório entre o min e o max (exclusivo) e adiciona o min para que o número gerado seja entre 0 e 100
            tentativas++;
            System.out.format("Computador tentou: %d\n", tentativaComputador);
            if (tentativaComputador > num) { // Se a tentativa do computador for maior que o número a adivinhar, então o máximo passa a ser a tentativa do computador
                max = tentativaComputador;
            } else if (tentativaComputador < num) { // Se a tentativa do computador for menor que o número a adivinhar, então o mínimo passa a ser a tentativa do computador
                min = tentativaComputador + 1; // Adiciona-se 1 para que o mínimo seja sempre maior que a tentativa do computador
            }
        } while (tentativaComputador != num);
        System.out.format("O computador acertou em %d tentativas.\n", tentativas);
        return tentativas;
    }

}