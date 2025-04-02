package TwoPointers;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {

        int[] array = {2,5,6,7};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(array, target)));

    }

    public static int[] twoSum(int[] numbers, int target){

        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while(left < right){
            if((numbers[left] + numbers[right]) == target){
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }else if((numbers[left] + numbers[right]) < target){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }

}
