public class Result {
//    класс для вычисления. И проверка ошибки деления на ноль Это тестовый вариант для проверки ПР
    public static int calculate (int a, int b, String oper) {
        int res;
        if (a < 1 || a > 10 || b < 1 || b > 10) throw new IllegalArgumentException("Цифры должны быть в пределах от 1 до 10. Выход! ");
        switch (oper) {
            case "+" : res = a + b; break;
            case "-" : res = a - b; break;
            case "*" : res = a * b; break;
            case "/" : if (b == 0) {
                throw new ArithmeticException("Нельзя делить на ноль тут у нас. Завершаемся (");
            } else {
                res = a / b;
                break;
            }
            default: throw new IllegalArgumentException("Я не волшебник, только учусь и пока не умею делать такие операции!\n До новых встреч!");
        }
        return (res);
    }
}
