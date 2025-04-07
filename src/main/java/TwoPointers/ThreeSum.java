package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[][] testCases = {
                {-1, 0, 1, 2, -1, -4},     // Exemplo clássico -> [[-1, -1, 2], [-1, 0, 1]]
                {0, 0, 0, 0},              // Só zeros -> [[0, 0, 0]]
                {-2, 0, 0, 2, 2},          // Com duplicados -> [[-2, 0, 2]]
                {-1, -1, 2, 2, 0},         // Diversos pares -> [[-1, -1, 2], [-1, 0, 1]]
                {1, 2, -2, -1},            // Nenhuma soma dá 0 -> []
                {-4, -2, -2, -2, 0, 1, 2, 2, 3, 3, 4, 4, 6, 6}, // Exemplo extenso
                {},                       // Array vazio -> []
                {0, 1},                   // Menos de 3 elementos -> []
                {-1, -1, -1, 2, 2}        // Dois triplos iguais possíveis -> [[-1, -1, 2]]
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Caso " + (i + 1) + ": " + Arrays.toString(testCases[i]));
            List<List<Integer>> resultado = threeSum(testCases[i]);
            System.out.println("Triplos encontrados: " + resultado);
            System.out.println("-------------");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) { // Garante que tem pelo menos dois números à frente (nums.length-2)
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // se houver duplicados tipo [-1,-1, 0, 1,2] Com o if (i > 0 && nums[i] == nums[i - 1]) continue;, a segunda iteração com -1 é saltada.
            }
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    List<Integer> triplo = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(triplo);
                    left++;
                    right--;
                    // Este ciclo salta todos os valores iguais ao anterior, evitando repetir o mesmo triplo.
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Este ciclo salta todos os valores iguais ao anterior, evitando repetir o mesmo triplo.
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    // Se left/right estava em 0, e o próximo left/right também for 0, então o triplo [ -1, 0, 1 ] apareceria de novo — o while evita isso.
                }
            }
        }
        return result;
    }
}
