import  java.util.TreeMap;
public class Converter {
    TreeMap<Character,Integer> romanKeyMap=new TreeMap<>();
    TreeMap<Integer,String> araKeyMap=new TreeMap<>();
    public Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        araKeyMap.put(1000, "M");
        araKeyMap.put(900, "CM");
        araKeyMap.put(500, "D");
        araKeyMap.put(400, "CD");
        araKeyMap.put(100, "C");
        araKeyMap.put(90, "XC");
        araKeyMap.put(50, "L");
        araKeyMap.put(40, "XL");
        araKeyMap.put(10, "X");
        araKeyMap.put(9, "IX");
        araKeyMap.put(5, "V");
        araKeyMap.put(4, "IV");
        araKeyMap.put(1, "I");
    }
    public String intToRoman(int num){
        String roman="";
        int aravKey;
        do{
            aravKey=araKeyMap.floorKey(num);
            roman+= araKeyMap.get(aravKey);
            num-=aravKey;
        }
        while (num!=0);
        return roman;
    }
    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romanKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKeyMap.get(arr[i]);

            if (arabian < romanKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}
