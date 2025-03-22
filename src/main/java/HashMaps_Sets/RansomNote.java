package HashMaps_Sets;

import java.util.HashMap;

public class RansomNote {

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

    }

    // a->2; b->1
    // primeira iteracao a->1 (map.get(ransomNoteChar) -1
    // segunda iteracao a-> 0 (map.get(ransomNoteChar) -1
    // return true

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.matches("^[^0-9]*$") && magazine.matches("^[^0-9]*$")) {
            char[] ransomNoteArray = ransomNote.toCharArray();
            char[] magazineArray = magazine.toCharArray();

            HashMap<Character, Integer> map = new HashMap<>();

            for (char magazineChar : magazineArray) {
                map.put(magazineChar, map.getOrDefault(magazineChar, 0) + 1);
            }

            for (char ransomNoteChar : ransomNoteArray) {
                if (map.containsKey(ransomNoteChar) && map.get(ransomNoteChar) > 0) {
                    map.put(ransomNoteChar, map.get(ransomNoteChar) - 1);
                } else {
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("As Strings não podem conter números");
            return false;
        }
    }
}
