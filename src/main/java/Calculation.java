import java.util.Scanner;

public class Calculation {

    public int inputNumber() {
        int num = 0;

        System.out.println("Input number: ");

        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()){
            num = scan.nextInt();
            if(!checkFirstTenNumbers(num)){
                num = inputNumber();
            }
        } else{
            System.out.println("Wrong number format! Input only integer digits!");
            num = inputNumber();
        }
        return num;
    }

    public char inputOperation(){
        boolean flag = false;
        char opers[] = new char[4];
        opers[0] = '+';
        opers[1] = '-';
        opers[2] = '*';
        opers[3] = '/';

        System.out.println("Input operation: ");

        Scanner scan = new Scanner(System.in);
        char operation = scan.next().charAt(0);

        for(int i=0; i< opers.length; i++){
            if(operation == opers[i]) {
                flag = true;
                break;
            }
        }

        if(!flag){
            System.out.println("Wrong operation! Input operation again: ");
            operation = inputOperation();
        }

        return operation;
    }

    public boolean checkFirstTenNumbers(int n){
        boolean flag = false;

        if(n > 10){
            System.out.println("Wrong number! The number must be from 0 to 10!");
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    public int getSum(int n1, int n2){
        return n1 + n2;
    }

    public int getSub(int n1, int n2){
        return n1 - n2;
    }

    public int getMult(int n1, int n2){
        return n1 * n2;
    }

    public int getDiv(int n1, int n2){
        if(n2 != 0) {
            return n1 / n2;
        } else {
            System.out.println("The divisor is zero!");
            return 0;
        }
    }

    public int calculation(int n1, int n2, char op){
        int result = 0;

        switch (op) {
            case '+':
                result = getSum(n1, n2);
                break;
            case '-':
                result = getSub(n1, n2);
                break;
            case '*':
                result = getMult(n1, n2);
                break;
            case '/':
                result = getDiv(n1, n2);
                break;
        }

        return result;
    }
}
