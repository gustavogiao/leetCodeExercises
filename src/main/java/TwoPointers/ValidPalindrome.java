package TwoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {

        String s = "A man a Plan a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindromeB(s));

    }

    public static boolean isPalindrome(String s){

        if(s.isEmpty()){ // exemplo " "
            return true;
        }

        StringBuilder limpa = new StringBuilder(); // para limpar a string
        for (char c : s.toCharArray()) { // percorre a string
            if (Character.isLetterOrDigit(c)) { // se o caracter for uma letra ou digito
                limpa.append(Character.toLowerCase(c)); // adiciona ao limpa esse caracter
            }
        }

        char[] caracteres = limpa.toString().toCharArray(); // cria-se array com esse string builder

        int left = 0; // inicio
        int right = caracteres.length - 1; // fim

        while(left < right){ // até ao meio, ou enquanto left for menor que right
            if(caracteres[left] == caracteres[right]){ // se o caracter da posicao left for igual ao caracter da posicao right
                left++; // avança-se a casa da esquerda
                right--; // reduz-se a casa da direita
            }else{
                return false; // não é palindrome, porque há pelo menos uma letra diferente
            }
        }
        return true; // é palindrome
    }

    public static boolean isPalindromeB(String s){

        if(s.isEmpty()){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // left < right para evitar StringIndexOutOfBoundsException exemplo: String s = ":::   !!!"; Nenhum s.charAt(left) vai ser alfanumérico, os ponteiros left e right vão-se aproximando, eventualmente left pode ultrapassar right
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) { // averigua se left é menor que right e se o caracter nessa posição não é uma letra ou digito
                left++; // avanca o left
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) { // se nao for letra nem numero
                right--; // diminui o right
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // se forem diferentes, não é palindrome
            }

            // caso sejam iguais
            left++;
            right--;
        }

        return true; // é palindrome

    }

}
