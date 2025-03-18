package ArraysStrings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] srts = {"flower", "flow", "flight"};
        System.out.println("Prefixo Comum: " + longestCommonPrefixString(srts));
    }

    public static String longestCommonPrefixString(String[] args) {
        if (args == null || args.length == 0) return "";

        String prefix = args[0]; // Assume o primeiro como prefixo inicial

        for (int i = 1; i < args.length; i++) { // Percorre todas as palavras
            while (args[i].indexOf(prefix) != 0) { // Enquanto `prefix` não for um prefixo válido
                prefix = prefix.substring(0, prefix.length() - 1); // Reduz o prefixo
                if (prefix.isEmpty()) return ""; // Se ficou vazio, não há prefixo comum
            }
        }

        // Mantive a funcionalidade de imprimir letras repetidas no prefixo comum
        for (int i = 0; i < prefix.length(); i++) {
            System.out.println("Letra Repetida: " + prefix.charAt(i));
        }

        return prefix;
    }
}
