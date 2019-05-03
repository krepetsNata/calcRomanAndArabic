import java.util.Scanner;

public class Calculation {

    /**
     * ввод арабского числа
     * @return валидное число
     */
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

    /**
     * ввод операции которую нужно произвести над двумя числами
     * @return валидный знак операции над числами
     */
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

    /**
     * проверка чтобы вводимое число не было больше 10
     * @param n проверяемое число
     * @return число с которым в дальнейшем будут проводиться операции
     */
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

    /**
     * складывает заданные числа
     * @param n1 слагаемое
     * @param n2 слагаемое
     * @return сумма заданных слагаемых
     */
    public int getSum(int n1, int n2){
        return n1 + n2;
    }

    /**
     * разность заданных чисел
     * @param n1 уменьшаемое
     * @param n2 вычетаемое
     * @return разность заданных чисел
     */
    public int getSub(int n1, int n2){
        return n1 - n2;
    }

    /**
     * произведение заданных чисел
     * @param n1 множимое
     * @param n2 множитель
     * @return произведение заданных чисел
     */
    public int getMult(int n1, int n2){
        return n1 * n2;
    }

    /**
     * отношение заданных чисел
     * @param n1 делимое
     * @param n2 делитель
     * @return отношение заданных чисел
     */
    public int getDiv(int n1, int n2){
        if(n2 != 0) {
            return n1 / n2;
        } else {
            System.out.println("The divisor is zero!");
            return 0;
        }
    }

    /**
     * результат операции над аргументами
     * @param n1 аргумент
     * @param n2 аргумент
     * @param op операция над аргументами
     * @return результат операции над аргументами
     */
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
