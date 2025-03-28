package HashMaps_Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> resultado = groupAnagrams(strs);
        System.out.println(resultado);

    }

    //  palavra      chave       já existe?          ação a executar
    //  "eat"	    "aet"	    ❌ Não	        cria nova lista	{ "aet" → ["eat"] }
    //  "tea"	    "aet"	    ✅ Sim	        adiciona à lista existente	{ "aet" → ["eat", "tea"] }

    public static List<List<String>> groupAnagrams(String[] strs){

        HashMap<String, List<String>> hash = new HashMap<>();

        for(String str : strs){
            String chave = ordenar(str);

            if(hash.containsKey(chave)){ // se a chave ja estiver no mapa
                hash.get(chave).add(str); // obtem se a lista e adiciona-se a palavra original à lista existente
            }else{ // se nao tiver no mapa
                List<String> strings = new ArrayList<>(); // cria-se uma nova lista
                strings.add(str); // adiciona-se a palavra a essa lista
                hash.put(chave, strings); // inserimos essa chave (ordem) e a lista ao hash
            }
        }

        return new ArrayList<>(hash.values());

    }

    private static String ordenar(String str) {
        char[] strChars = str.toCharArray();
        Arrays.sort(strChars);
        return new String(strChars);
    }

}
