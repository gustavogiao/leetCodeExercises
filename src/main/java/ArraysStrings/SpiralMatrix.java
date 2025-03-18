package ArraysStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix){

        List<Integer> espiral = new ArrayList<>();

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right){

            // Percorrer da esquerda para a direita
            for (int i = left; i <= right ; i++) {
                espiral.add(matrix[top][i]); // Percorrer a linha superior, da esquerda para a direita.
            }
            top++; // Aumentar o top para não repetir a linha superior

            // Percorrer de cima para baixo
            for (int i = top; i <= bottom ; i++) {
                espiral.add(matrix[i][right]); // Percorrer a coluna da direita, de cima para baixo.
            }
            right--; // Diminuir o right para não repetir a coluna da direita

            if(top <= bottom) {
                //Percorrer da direita para a esquerda
                for (int i = right; i >= left; i--) {
                    espiral.add(matrix[bottom][i]); // Percorrer a linha inferior, da direita para a esquerda.
                }
                bottom--; // Diminuir o bottom para não repetir a linha inferior
            }

            // Percorrer de baixo para cima
            if(left <= right){
                for (int i = bottom; i >= top ; i--) {
                    espiral.add(matrix[i][left]); // Percorrer a coluna da esquerda, de baixo para cima.
                }
                left++; // Aumentar o left para não repetir a coluna da esquerda
            }
        }

        return espiral;

    }

}
