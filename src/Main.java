import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        Pattern pattern = Pattern.compile("(10|[0-9])[+\\-*/](10|[0-9])");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine().replaceAll(" ", "");
        while (!data.equals("q")) {
            if (!pattern.matcher(data).matches()) {
                System.out.println("throws Exception");
                throw new Exception("throws Exception");
            }
            System.out.println(calc(data));
            data = scanner.nextLine().replaceAll(" ", "");
        }

    }

    public static String calc(String input) {
        String[] split = input.split("(?<=[+\\-*/])|(?=[+\\-*/])");
        int num1 = Integer.parseInt(split[0]);
        String action = split[1];
        int num2 = Integer.parseInt(split[2]);

        return String.valueOf(switch (action) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    yield "ААААААА!!!! Попытка деления на ноль! ААААААА!!!!!";
                }
                yield num1 / num2;
            }
            default -> "Внутренняя ошибка приложения. Жизнь - боль!";
        });
    };
}
