package HashMaps_Sets;

import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t){

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        HashMap<Character, Integer> hash = new HashMap<>();

        for (char c : sArray){
            if(hash.containsKey(c)){
                hash.put(c, hash.get(c) + 1);
            }else{
                return false;
            }
        }

        for(char c : tArray){
            if(hash.containsKey(c)){
                hash.put(c, hash.get(c) - 1);
            }else{
                hash.put(c, 1);
            }
        }

        for(HashMap<Character, Integer> )

    }

}
