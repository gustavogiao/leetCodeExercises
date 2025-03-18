package ArraysStrings;

public class findClosestNumber {
    public static void main(String[] args) {
        int[] array = {-4, -2, 5, 4, 8};
        System.out.println(findClosestNumber(array));
        int[] array2 = {2, -1, 1};
        System.out.println(findClosestNumber(array2));
    }

    public static int findClosestNumber(int[] nums){
        int closestNumber = Integer.MAX_VALUE; // set the closest number to the maximum value of an integer
        for (int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i]) < Math.abs(closestNumber) || (Math.abs(nums[i]) == Math.abs(closestNumber) && nums[i] > closestNumber )){ // if the absolute value of the current number is less than the absolute value of the closest number or if the absolute value of the current number is equal to the absolute value of the closest number and the current number is greater than the closest number
                closestNumber = nums[i];
            }
        }

        return closestNumber;
    }
}

// Math.abs - returns the absolute value of a number
