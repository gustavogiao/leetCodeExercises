package TwoPointers;

import static java.lang.Math.min;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){

        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while(left < right){ // repete-se até left e right se encontrarem
            int altura = min(height[left], height[right]); // a altura é determinada pela linha mais baixa entre as duas linhas
            int largura = right - left; // A largura do recipiente é a distância horizontal entre os dois ponteiros.
            int area = altura * largura; // área (ou volume de água) que esse recipiente pode conter

            if(area > result){
                result = area; // Se a área calculada for maior que a maior área que tinha encontrado até agora (result), atualiza o result.
            }

            if(height[left] < height[right]){
                left++; // Se a linha da esquerda é mais baixa, avanças o ponteiro da esquerda, na esperança de encontrar uma linha mais alta que possa aumentar a área.
            }else{
                right--; // Se a linha da direita é mais baixa (ou são iguais), recua o ponteiro da direita.
            }

        }

        return result;

    }

}
// 🚀 Primeira iteração:                 // 🚀 Segunda iteração
// left = 0   -> height[0] = 1           // left = 1 -> height[1] = 8
//right = 8  -> height[8] = 7            // right = 8 -> height[8] = 7

// Altura = min(1, 7) = 1               // Altura = min(8, 7) = 7
//Largura = 8 - 0 = 8                   // Largura = 8 - 1 = 7
//Área = 1 × 8 = 8                      // Área = 7 × 7 = 49 ✅

// como height[left] < height[right]   // continua a percorrer, mas nenhum result bate este:
// entao left++;                       //  🎯 Esta é a melhor combinação possível no array: height[1] e height[8].

