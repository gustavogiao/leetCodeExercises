package TwoPointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static void main(String[] args) {

        int nums[] = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
        System.out.println(Arrays.toString(sortedSquaresTwoPointers(nums)));
    }

    // two pointers way
    public static int[] sortedSquaresTwoPointers(int[] nums){

        int length = nums.length;
        int[] result = new int[length]; // Array de saída
        int left = 0; // Ponteiro Um
        int right = length - 1; // Ponteiro Dois
        int position = length - 1; // Começa a preencher do fim

        while (left <= right){
            int leftValue = nums[left];
            int rightValue = nums[right];

            // Compara os valores absolutos dos dois lados
            if(Math.abs(leftValue) > Math.abs(rightValue)){
                result[position--] = leftValue * leftValue; // Quadrado do maior valor absoluto
                left++; // Avança o ponteiro da esq
            }else{
                result[position--] = rightValue * rightValue;
                right--; // Recua o ponteiro da dir
            }
        }
        return result;
    }


    // vanilla way
    public static int[] sortedSquares(int[] nums){

        int[] array = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(array);
        return array;

    }

}
