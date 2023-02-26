public class ReadRomeArab {

    private final int num;
    private static int[] numbers = {100,   90, 50,   40,   10,    9,    5,    4,    1 };
    private static String[] letters = {"C",  "XC", "L",  "XL",  "X",  "IX", "V",  "IV", "I" };

    public ReadRomeArab(int arabic) { // вход - целое, выход - римское число
        if (arabic < 1) throw new NumberFormatException("Упс... Результат - отрицательное число. Я не умею переводить такие в римские цифры... Срочный выход!");
        num = arabic;
    }

    public ReadRomeArab(String roman) { // вход римское (строка), выход - целое
        if (roman.length() == 0) throw new NumberFormatException("Обманули демоны! Подсунули пустое место!!! Выход!.");
        roman = roman.toUpperCase();  // в верхний регистр переведем

        int i = 0;
        int arabic = 0;

        while (i < roman.length()) {

            char letter = roman.charAt(i);
            int number = letterToNumber(letter);

            if (number < 0)
                throw new NumberFormatException("Проверьте - вот этот символ \"" + letter + "\", мне кажется, не используется в романских цифрах.. Либо неверный порядок аргументов");

            i++;

            if (i == roman.length()) {
                 arabic += number;
            }
            else {
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                   arabic += number;
                }
            }

        }  // end while

        if (arabic > 100)
            throw new NumberFormatException("Что-то намудрили. Перебор...");

        num = arabic;

    }


    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            default:   return -1;
        }
    }


    public String toString() {
        String roman = "";
        int N = num;
        for (int i = 0; i < numbers.length; i++) {
            while (N >= numbers[i]) {
                roman += letters[i];
                N -= numbers[i];
            }
        }
        return roman;
    }

    public int toInt() {
        return num;
    }

}
