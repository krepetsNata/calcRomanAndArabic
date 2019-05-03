import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        RomanNumerals romanNumerals = new RomanNumerals();
        Calculation calculation = new Calculation();

        System.out.println("calculator that performs operations on Arabic and Roman numerals");
        String chooseNum = "";

        while(!chooseNum.equalsIgnoreCase("E")) {
             System.out.println("\n================================================================");
             System.out.println("\nselect and enter the type of numbers you will work with:\n r - Roman numerals\n a - Arabic numerals\n e - exit\n");
             Scanner scan = new Scanner(System.in);
             chooseNum = scan.next();

            if (chooseNum.equalsIgnoreCase("A")) {
                int n1 = calculation.inputNumber();
                int n2 = calculation.inputNumber();
                char op = calculation.inputOperation();

                System.out.printf("%d %s %d = %d", n1, op, n2, calculation.calculation(n1, n2, op));

            } else if (chooseNum.equalsIgnoreCase("R")) {
                String r1 = romanNumerals.inputRomanNumber();
                String r2 = romanNumerals.inputRomanNumber();
                char op = calculation.inputOperation();
                int resultA = calculation.calculation(romanNumerals.convertRomanToArabic(r1), romanNumerals.convertRomanToArabic(r2), op);
                String resultR = romanNumerals.convertArabicToRoman(resultA);

                System.out.printf("%s %s %s = %s", r1, op, r2, resultR);

            } else if (chooseNum.equalsIgnoreCase("R")) {
                System.out.println("Goodbye!");
            }else {
                System.out.println("Wrong letter!");
            }
        }
    }
}
