package ArraysStrings;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {

        // Transpor a matriz (trocar as linhas pelas colunas)
        for (int i = 0; i < matrix.length - 1; i++) { // Percorre as linhas
            for (int j = i + 1; j < matrix.length; j++) { // Percorre as colunas
                int temp = matrix[i][j]; // Guarda o valor da posição atual
                matrix[i][j] = matrix[j][i]; // Troca o valor da posição atual com o valor da posição oposta
                matrix[j][i] = temp; // Atribui o valor guardado na posição oposta
            }
        }

        // Inverter cada linha (trocar a primeira coluna com a última, a segunda com a penúltima, e assim por diante)
        for (int i = 0; i < matrix.length; i++) { // Percorre as linhas
            for (int j = 0; j < matrix.length / 2; j++) { // Percorre as colunas até a metade
                int temp = matrix[i][j]; // Guarda o valor da posição atual
                matrix[i][j] = matrix[i][matrix.length - 1 - j]; // Troca o valor da posição atual com o valor da posição oposta
                matrix[i][matrix.length - 1 - j] = temp; // Atribui o valor guardado na posição oposta
            }
        }

        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // Percorre as linhas
            for (int j = 0; j < matrix[i].length; j++) { // Percorre as colunas
                System.out.printf("%3d ", matrix[i][j]); // Imprime com espaçamento fixo
            }
            System.out.println(); // Nova linha após imprimir uma linha completa
        }
    }

}
