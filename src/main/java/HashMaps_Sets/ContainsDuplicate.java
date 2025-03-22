package HashMaps_Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] array = {1,2,3,3};
        System.out.println(containsDuplicate(array));
        System.out.println(containsDuplicateSet(array));
        System.out.println(containsDuplicateHash(array));

    }

    public static boolean containsDuplicate(int[] nums){

        boolean isDuplicated = false;
        for (int i = 0; i < nums.length; i++) {
            int atual = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(i != j){
                    int outro = nums[j];
                    if(atual == outro){
                        isDuplicated = true;
                    }
                }
            }
        }

        return isDuplicated;

    }

    public static boolean containsDuplicateSet(int[] nums){

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }

        return false;

    }

    public static boolean containsDuplicateHash(int[] nums){

        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                return true;
            }else{
                map.put(num, true);
            }
        }
        return false;
    }

}
