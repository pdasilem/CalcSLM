import java.util.Scanner;

public class CalcSLM {
    /* Тестовое задание.
    Задача - написать консольный калькулятор арабских и римских цифр (два значения
    от 0 до 10. Пересечение арабские - римские запрещено. Вывод в формате исходных чисел.)
    Калькулятор принимает только целые числа и выдает результат в целых числах!
    Автор: Мельников Сергей, pdasilem@gmail.com
     */
    public static void main(String[] args) {
        int a1, c1;
        String a2, b, c2;
        int result;
        System.out.println("Добро пожаловать!\nПеред вами простой консольный калькулятор, который умеет выполнять" +
                " операции сложения, вычитания, умножения и деления двух чисел.\n" +
                "Введите через пробелы два числа от 1 до 10 и знак действия между ними\n" +
                "Фишка! - Можно юзать римские цифры :)");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            a1 = scan.nextInt();
            b = scan.next();
            if (scan.hasNextInt()) c1 = scan.nextInt(); else throw new IllegalArgumentException("Верный порядок ввода - целое число действие целое число");
            result = Result.calculate(a1, c1, b);
            System.out.println(result);
        } else {
            a2 = scan.next();
            b = scan.next();
            c2 = scan.next();
            ReadRomeArab a = new ReadRomeArab(a2);
            ReadRomeArab c = new ReadRomeArab(c2);
            result = Result.calculate(a.toInt(), c.toInt(), b);
            ReadRomeArab res = new ReadRomeArab(result);
            System.out.println(res.toString());
        }
       scan.close();
    }
}
