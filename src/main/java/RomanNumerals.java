import java.util.*;

public class RomanNumerals {

    //сортированный по убыванию список ключей и значений римских чисел
    Map<String, Integer> sortedRomanNumsMap = new LinkedHashMap<>();

    //коллекция римских чисел(ключ) и их соответствия в арабских числах(значение)
    private Map<String, Integer> romanNumsMap = new HashMap<String, Integer>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    //получить коллекцию
    public Map<String, Integer> getRomanNumsMap() {
        return romanNumsMap;
    }

    /**
     * сортировка коллекции римских чисел по убыванию
     * @return новая коллекция римских чисел
     */
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

    /**
     * ввод римского числа
     * @return валидное римское число
     */
    public String inputRomanNumber(){
        String romanNum = "";

        System.out.println("Input number: ");

        Scanner scan = new Scanner(System.in);
        if (scan.hasNext("[ivxlcdmIVXLCDM]*")){
            romanNum = scan.next();
        } else{
            System.out.println("Wrong number format! Input only roman digits - i, v, x, l, c, d, m!");
            romanNum = inputRomanNumber();
        }
        return romanNum;
    }

    /**
     * конвертация римского числа в арабское (для произведения операций над числом)
     * @param romanNumber римское число
     * @return арабское число
     */
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

    /**
     * конвертация арабского числа в римское (для отображения результата операций над числом)
     * @param arabicNumber арабское число
     * @return римское число
     */
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
