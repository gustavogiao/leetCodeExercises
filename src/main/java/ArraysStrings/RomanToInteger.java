package ArraysStrings;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        char[] arrayCaractheres = s.toCharArray();
        int result = 0;

        for (int i = 0; i < arrayCaractheres.length; i++) {
            if(i>0 && shouldSubtract(arrayCaractheres[i-1], arrayCaractheres[i])){
                result -= getRomanValue(arrayCaractheres[i-1]) * 2;
            }
            result += getRomanValue(arrayCaractheres[i]);
        }

        return result;

    }

    public static boolean shouldSubtract(char prev, char curr){
        boolean b = false;
        if(prev == 'I' && (curr == 'V' || curr == 'X')){
            b = true;
        }else if(prev == 'X' && (curr == 'L' || curr == 'C')){
            b = true;
        }else if(prev == 'C' && (curr == 'D' || curr == 'M')){
            b = true;
        }
        return b;
    }

    public static int getRomanValue(char c){
        return switch (c){
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}
