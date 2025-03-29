package HashMaps_Sets;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementBoyer(nums));
    }

    // 2 -> 4 ; 1 -> 3

    public static int majorityElement(int[] nums){

        HashMap<Integer, Integer> hash = new HashMap<>();
        int maiorElemento = 0;
        int maiorContagem = 0;


        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> map : hash.entrySet()){
            if(map.getValue() > maiorContagem){
                maiorContagem = map.getValue();
                maiorElemento = map.getKey();
            }

        }

        return maiorElemento;

    }

    // with Boyer-Moore Majority Vote Algorithm

    public static int majorityElementBoyer(int[] nums){

        int candidato = 0;
        int contador = 0;

        for(int num : nums){
            if(contador == 0){
                candidato = num;
            }
            if(candidato == num){
                contador++;
            }else{
                contador--;
            }
        }
        return candidato;
    }

}
