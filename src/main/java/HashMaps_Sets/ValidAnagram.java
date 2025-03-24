package HashMaps_Sets;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "aabbcc";
        String t = "abcabc";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramB(s, t));

    }

    public static boolean isAnagram(String s, String t){

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        HashMap<Character, Integer> hash = new HashMap<>();

        for (char c : sArray){
                hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for(char c : tArray){
                hash.put(c, hash.getOrDefault(c, 0) - 1);
        }

        for(Integer values : hash.values()){
            if(values != 0){
                return false;
            }
        }

        return true;

    }

    public static boolean isAnagramB(String s, String t){
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        Arrays.sort(arrayS);
        Arrays.sort(arrayT);

        if(arrayS.length != arrayT.length){
            return false;
        }
        return Arrays.equals(arrayS, arrayT);
    }
}
