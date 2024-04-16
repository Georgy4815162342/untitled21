import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите выражение:");
        Scanner q = new Scanner(System.in);
        String oper = q.nextLine();
        calc(oper);}
     static void calc(String oper) throws IOException {
         Converter converter = new Converter();
         String[] operation = {"+", "-", "*", "/"};
         String[] operation2 = {"\\+", "-", "\\*", "/"};
         int operIndex = 9;
         for (int i = 0; i < operation.length; i++) {
             if (oper.contains(operation[i])) {
                 operIndex = i;
                 break;}}
if (operIndex==9){
                 throw new IOException();//Cтрока не является математической операцией
                }
        String[] data = oper.split(operation2[operIndex]);
        if (data.length!=2){
                        throw new IOException();//Формат математической операции не удовлетворяет заданию - два операнда и один оператор
                    }
            if (data[0].contains("I") || data[0].contains("V") || data[0].contains("X")
                    || data[0].contains("1") || data[0].contains("2") || data[0].contains("3") || data[0].contains("4") || data[0].contains("5")
                    || data[0].contains("6") || data[0].contains("7") || data[0].contains("8") || data[0].contains("9")
                    && data[1].contains("I") || data[1].contains("V") || data[1].contains("X")
                    || data[1].contains("1") || data[1].contains("2") || data[1].contains("3") || data[1].contains("4") || data[1].contains("5")
                    || data[1].contains("6") || data[1].contains("7") || data[1].contains("8") || data[1].contains("9")) {
                if ((data[0].contains("I") || data[0].contains("V") || data[0].contains("X")) &&
                        (data[1].contains("1") ||
                                data[1].contains("2") || data[1].contains("3") || data[1].contains("4") || data[1].contains("5") ||
                                data[1].contains("6") || data[1].contains("7") ||
                                data[1].contains("8") || data[1].contains("9"))) {
                        throw new IOException(); // Используются одновременно разные системы счисления
                    }
                if ((data[1].contains("I") || data[1].contains("V") || data[1].contains("X")) &&
                        (data[0].contains("1") || data[0].contains("2") | data[0].contains("3")
                                || data[0].contains("4") || data[0].contains("5") || data[0].contains("6") || data[0].contains("7") ||
                                data[0].contains("8") || data[0].contains("9"))) {
                        throw new IOException();//Используются одновременно разные системы счисления
                    }
                }
                int a, b;
                if (data[0].contains("I") || data[0].contains("V") || data[0].contains("X") &&
                        data[1].contains("I") || data[1].contains("V") || data[1].contains("X")) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);
                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                if (oper.contains("1") || oper.contains("2") || oper.contains("3") || oper.contains("4") || oper.contains("5")
                        || oper.contains("6") || oper.contains("7") || oper.contains("8") || oper.contains("9")) {
                    if (a > 10 || b > 10) {
                            throw new IOException();//Вводите значения не больше 10
                    }
                    int result;
                    if (operation[operIndex] == "+") {
                        result = a + b;
                        System.out.println(result);
                        return;
                    } else if (operation[operIndex] == "-") {
                        result = a - b;
                        System.out.println(result);
                        return;
                    } else if (operation[operIndex] == "*") {
                        result = a * b;
                        System.out.println(result);
                        return;
                    } else if (operation[operIndex] == "/") {
                        result = a / b;
                        System.out.println(result);
                        return;
                    }
                } else if (data[0].contains("I") || data[0].contains("V") || data[0].contains("X") &&
                        data[1].contains("I") || data[1].contains("V") || data[1].contains("X")) {
                    if (a > 10 || b > 10) {
                            throw new IOException();//Вводите значения не более X
                        }
                int resultR;
                if (operation[operIndex] == "+") {
                    resultR = a + b;
                    System.out.println(converter.intToRoman(resultR));
                } else if (operation[operIndex] == "-") {
                    resultR = a - b;
                    if (resultR <= 0) {
                            throw new IOException();//В римской системе исчисления нет нуля и отрицательных значений
                    }
                    System.out.println(converter.intToRoman(resultR));
                } else if (operation[operIndex] == "*") {
                    resultR = a * b;
                    System.out.println(converter.intToRoman(resultR));
                } else if (operation[operIndex] == "/") {
                    resultR = a / b;
                    System.out.println(converter.intToRoman(resultR));
                }
            } else  {
                    throw new IOException();//Вы ввели некорректное значение
            }
        }
    }
