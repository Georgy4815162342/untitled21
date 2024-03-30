import java.util.Scanner;
public class Main {
    public static void main(String[] calc) {
        Converter converter = new Converter();
        String[] operation = {"+", "-", "*", "/"};
        String[] operation2 = {"\\+", "-", "\\*", "/"};
        System.out.println("Введите выражение:");
        Scanner q = new Scanner(System.in);
        String oper = q.nextLine();
        int operIndex=9;
        for (int i = 0; i < operation.length; i++) {
            if (oper.contains(operation[i])){
                operIndex = i;
                break;
            }

        }
        if (operIndex == 9) {
            System.out.println("Cтрока не является математической операцией");
            return;
        }


        String[] data = oper.split(operation2[operIndex]);
        if (data.length != 2) {
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
            return;
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
                System.out.println("Используются одновременно разные системы счисления");
                return;
            }
            if ((data[1].contains("I") || data[1].contains("V") || data[1].contains("X")) &&
                    (data[0].contains("1") || data[0].contains("2") | data[0].contains("3")
                            || data[0].contains("4") || data[0].contains("5") || data[0].contains("6") || data[0].contains("7") ||
                            data[0].contains("8") || data[0].contains("9"))) {
                System.out.println("Значения должны быть в одном формате");
                return;
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
            if (a>10||b>10){
                System.out.println("iiii");
            }
            if (oper.contains("1") || oper.contains("2") || oper.contains("3") || oper.contains("4") || oper.contains("5")
                    || oper.contains("6") || oper.contains("7") || oper.contains("8") || oper.contains("9")) {
                String w = data[0];
                String e = data[1];
                char[] strToArray = w.toCharArray();
                if (strToArray.length > 1) {
                    System.out.println("Вводите значения меньше 10");
                    return;
                }
                char[] strToArray1 = e.toCharArray();
                if (strToArray1.length > 1) {
                    System.out.println("Вводите значения меньше 10");
                    return;
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
                if (a > 9 || b > 9) {
                    System.out.println("Вводите значения меньше X");
                    return;
                }
            }
            int resultR;
            if (operation[operIndex] == "+") {
                resultR = a + b;
                System.out.println(converter.intToRoman(resultR));
            } else if (operation[operIndex] == "-") {
                resultR = a - b;
                if (resultR <= 0) {
                    System.out.println("В римской системе исчисления нет нуля и отрицательных значений");
                    return;
                }
                System.out.println(converter.intToRoman(resultR));
            } else if (operation[operIndex] == "*") {
                resultR = a * b;
                System.out.println(converter.intToRoman(resultR));
            } else if (operation[operIndex] == "/") {
                resultR = a / b;
                System.out.println(converter.intToRoman(resultR));
            }

        }else{
            System.out.println("Вы ввели некорректное значение");
            return;
        }}}
