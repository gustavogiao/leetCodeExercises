package TwoPointers;

public class ReverseString {

    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o'};
        reverseStringVanilla(s);
        reverseStringTwoPointers(s);
    }

    // o l l e h
    public static void reverseStringTwoPointers(char[] s){

        int left = 0;
        int right = s.length - 1;

        while(left < right){
            // fazer trocas entre elementos ate que chega ao meio
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++; // avancamos na esquerda
            right--; // recuamos na direira
        }
        System.out.println(new String(s));
    }

    public static void reverseStringVanilla(char[] s){

        for (int i = s.length - 1; i >= 0; i--) {
            System.out.println(s[i]);
        }

    }





}
