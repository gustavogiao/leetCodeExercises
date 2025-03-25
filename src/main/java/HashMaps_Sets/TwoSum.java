package HashMaps_Sets;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {3,2,4,7};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    // 6-3 = 3 (add, n existe) // 6-2 = 4 (add, n existe)
    // 6-4 = 2 (existe!!!) // return {1,2}

    public static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target - nums[i])){
                int[] indices = new int[] {hash.get(target - nums[i]), i};
                return indices;
            }
            hash.put(nums[i], i);
        }
        return null;
    }

}
