package HashMaps_Sets;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {

    public static void main(String[] args) {

        String palavra = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(palavra));

    }

    public static int maxNumberOfBalloons(String text){

        Map<Character, Integer> requisitos = Map.of(
                'b', 1,
                'a', 1,
                'l', 2,
                'o', 2,
                'n', 1
        );

        HashMap<Character, Integer> hash = new HashMap<>();

        for(char caracter : text.toCharArray()){
            hash.put(caracter, hash.getOrDefault(caracter, 0) + 1);
        }

        int minimo = Integer.MAX_VALUE;

        for(char caracter : requisitos.keySet()){
            minimo = Math.min(minimo, hash.getOrDefault(caracter, 0) / requisitos.get(caracter));
        }

        return minimo;

    }

}
