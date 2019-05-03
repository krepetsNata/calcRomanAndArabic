import java.util.*;

public class RomanNumerals {

    Map<String, Integer> sortedRomanNumsMap = new LinkedHashMap<>();
    private Map<String, Integer> romanNumsMap = new HashMap<String, Integer>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public Map<String, Integer> getRomanNumsMap() {
        return romanNumsMap;
    }

    public Map<String, Integer> sortedRomanMapsByValue(){

        List<Map.Entry<String, Integer>> list = new ArrayList(romanNumsMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            sortedRomanNumsMap.put(entry.getKey(), entry.getValue());
        }
        return sortedRomanNumsMap;
    }

    public String inputRomanNumber(){
        String romanNum = "";

        System.out.println("Input number: ");

        Scanner scan = new Scanner(System.in);
        if (scan.hasNext("[ivxlcdmIVXLCDM]*")){
            romanNum = scan.next();
            if(!checkFirstTenNumbers(romanNum)){
                romanNum = inputRomanNumber();
            }
        } else{
            System.out.println("Wrong number format! Input only roman digits - i, v, x, l, c, d, m!");
            romanNum = inputRomanNumber();
        }
        return romanNum;
    }

    public boolean checkFirstTenNumbers(String n){
        boolean flag = false;

        if(romanNumsMap.containsKey(n.charAt(0))){
            System.out.println("Wrong number! The number must be from I to M!");
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    public int convertRomanToArabic(String romanNumber){
        romanNumber = romanNumber.toUpperCase();
        int resArabicFromRomn = 0;

        for(int i=0; i<romanNumber.length(); i++){
            String s = String.valueOf(romanNumber.charAt(i));//substring(i);
            if (romanNumsMap.containsKey(s)){
                Object myValue = romanNumsMap.get(s);
                resArabicFromRomn+=((Integer) myValue).intValue();
            }
        }

        if (romanNumber.equals("IV")){
            resArabicFromRomn-=2;
        } if (romanNumber.equals("IX")){
            resArabicFromRomn-=2;
        }
        return resArabicFromRomn;
    }

    public String convertArabicToRoman(int arabicNumber) {
        StringBuilder resRomnFromArabic = new StringBuilder();

        for (Map.Entry<String, Integer> item : sortedRomanMapsByValue().entrySet()) {
            if (arabicNumber == 4){
                resRomnFromArabic.append("IV");
                arabicNumber -= 4;
            } if (arabicNumber == 9){
                resRomnFromArabic.append("IX");
                arabicNumber -= 9;
            }

            while (item.getValue() <= arabicNumber) {
                resRomnFromArabic.append(item.getKey());
                arabicNumber -= item.getValue();
            }
        }
        return resRomnFromArabic.toString();
    }

}
