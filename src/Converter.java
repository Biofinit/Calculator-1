import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> keyMapRom = new TreeMap<>();
    TreeMap<Integer, String> keyMapArab = new TreeMap<>();

    public Converter() {
        keyMapRom.put('I', 1);
        keyMapRom.put('V', 5);
        keyMapRom.put('X', 10);

        keyMapArab.put(100, "C");
        keyMapArab.put(90, "XC");
        keyMapArab.put(50, "L");
        keyMapArab.put(40, "XL");
        keyMapArab.put(10, "X");
        keyMapArab.put(9, "IX");
        keyMapArab.put(5, "V");
        keyMapArab.put(4, "IV");
        keyMapArab.put(1, "I");
    }
    public boolean isRoman(String number){
        return keyMapRom.containsKey(number.charAt(0));
    }
    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            try {
            arabianKey = keyMapArab.floorKey(number);
            roman += keyMapArab.get(arabianKey);
            number -= arabianKey;
            } catch (NullPointerException e){
                System.out.println("Римские числа не могут принимать отрицательное значение");
                break;
            }
        } while (number != 0);
        return roman;
    }
    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = keyMapRom.get(arr[end]);
        for (int i = end - 1; i >= 0; i --) {
            arabian = keyMapRom.get(arr[i]);

            if (arabian < keyMapRom.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}
