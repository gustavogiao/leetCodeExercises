package HashMaps_Sets;

import java.util.HashMap;
import java.util.HashSet;

public class JewelsStones {
    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
        System.out.println(numJewelsInStonesHashSet(jewels, stones));
        numJewelsInStonesHashMap(jewels, stones);
    }

    // Com arrays normais
    public static int numJewelsInStones(String jewels, String stones){

        int contador = 0;

        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if(stones.charAt(i) == jewels.charAt(j)){
                    contador++;
                    break;
                }
            }
        }

        return contador;

    }

    // Com HashSet
    public static int numJewelsInStonesHashSet(String jewels, String stones){

        char[] charStonesArray = stones.toCharArray();
        char[] charJewelsArray = jewels.toCharArray();
        HashSet<Character> jewelsHash = new HashSet<>();
        for (char jewel : charJewelsArray){
            jewelsHash.add(jewel);
        }

        int contador = 0;
        for(char stone : charStonesArray){
            if(jewelsHash.contains(stone)){
                contador++;
            }
        }
        return contador;
    }

    // Com HashMap
    public static void numJewelsInStonesHashMap(String jewels, String stones){

        char[] charStonesArray = stones.toCharArray();
        char[] charJewelsArray = jewels.toCharArray();

        HashMap<Character, Integer> jewelsHash = new HashMap<>();
        for(char jewel : charJewelsArray){
            jewelsHash.put(jewel, 0);
        }

        for (char stone : charStonesArray){
            if(jewelsHash.containsKey(stone)){
                jewelsHash.put(stone, jewelsHash.get(stone) + 1);
            }
        }

        for(char jewel : charJewelsArray){
            System.out.println("Joia '" + jewel + "' aparece " + jewelsHash.get(jewel) + " vezes.");
        }

    }
}
