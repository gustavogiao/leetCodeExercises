package ArraysStrings;

public class isSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde")); // true
        System.out.println(isSubsequence("aec", "abcde")); // false
    }

    public static boolean isSubsequence(String s, String t) {

        int indexS = 0;

        for (int i = 0; i < t.length(); i++) {
            if(indexS < s.length() && s.charAt(indexS) == t.charAt(i)){ // o index do S só avança quando encontra uma correspondência, até la mantem na mesma casa.
                indexS++;
            }
        }

        return indexS == s.length();

    }

}

// exemplo: indexS = 0 (olhamos para s.charAt(0), que é 'a').
//
//i = 0: t.charAt(0) = 'a'.
//Condição: 'a' == 'a' → Verdadeiro!
//Incrementamos indexS para 1.
//indexS = 1 (olhamos para s.charAt(1), que é 'b').
//
//i = 1: t.charAt(1) = 'h'.
//Condição: 'b' != 'h' → Falso!
//Continuamos o loop.
//
//i = 2: t.charAt(2) = 'b'.
//Condição: 'b' == 'b' → Verdadeiro!
//Incrementamos indexS para 2.

