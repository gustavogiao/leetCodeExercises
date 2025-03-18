package ArraysStrings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int acc = 1;
        int zeros = 0;

        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else {
                acc *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros > 1) {
                answer[i] = 0; // se tiver mais de um zero, o produto de todos os elementos será 0.
            } else if (zeros == 1) {
                if (nums[i] == 0) {
                    answer[i] = acc; // quando é 0, não é preciso dividir por ele mesmo.
                } else {
                    answer[i] = 0; // quando não é 0, o produto de todos os elementos será 0.
                }
            } else {
                answer[i] = acc / nums[i]; // quando não tem zero, divide o produto de todos os elementos pelo elemento atual.
            }
        }
        return answer;
    }
}
