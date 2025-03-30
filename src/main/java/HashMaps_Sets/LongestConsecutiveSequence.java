package HashMaps_Sets;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums = {100,4,200,1,3,2,2,5};
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums){

        Set<Integer> hash = new HashSet<>();

        for (int num : nums){
            hash.add(num);
        }

        int longest = 0;

        for (int num : hash){
            if(!hash.contains(num - 1)){ // se o numero anterior não existir, então é o inicio de uma sequencia
                int current = num; // current é o inicio da sequencia
                int streak = 1; // streak é o tamanho da sequencia

                while(hash.contains(current + 1)){ // enquanto o proximo numero existir, incrementa o current e o streak
                    current++;
                    streak++;
                }
                longest = Math.max(longest, streak); // longest é o maior valor entre o longest e o streak
            }
        }
    return longest;
    }
}
