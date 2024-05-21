import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {


        // First Task
        whenYouHas100Birthday();
        //Second Task
        int[] num = new int[]{10, -1, -2, 11, 2, 0};
        positiveNumbers(num);
        //Third task
        System.out.println(convertMoney("dsg100 BYN123", 3.2));
        //Fourth task
        convertMoneyAndPrint("dsg100 BYN123", 3.2);
        //Fifth task
        System.out.println(reverseString());
    }

    static void whenYouHas100Birthday() {
        // First Task

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате гггг-мм-дд и вы узнаете когда вам будет 100 лет");

        String data1 = scanner.nextLine();

        while (!checkDate(data1)) {
            System.out.println("Введите дату рождения в формате гггг-мм-дд");
            data1 = scanner.nextLine();
        }

        LocalDate date = LocalDate.parse(data1);
        System.out.println(date.plusYears(100));
    }

    static boolean checkDate(String date) {
        // First Task
        Pattern pattern = Pattern.compile("[0-9]{4}[-/.][0-9]{2}[-/.][0-9]{2}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    static void positiveNumbers(int[] num) {
        //Second Task
        Predicate<Integer> isPositive = x -> x >= 0;
        for (int n : num) {
            if (isPositive.test(n)) {
                System.out.println(n);
            }
        }
    }

    static double convertMoney(String money, double exchangeRate) {
        //Third task
        Function<String, Double> convert = m -> Double.parseDouble(trimStr(m)) * exchangeRate;
        return convert.apply(money);
    }

    static String trimStr(String money) {
        //Third task
        //Fourth task
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(money);
        matcher.find();
        return matcher.group();
    }

    static void convertMoneyAndPrint(String money, double exchangeRate) {
        //Fourth task
//        Consumer<String> convert = m -> System.out.println(Double.parseDouble(trimStr(m)) * exchangeRate + " USD");
        Consumer<String> convert = m -> System.out.println(convertMoney(money, exchangeRate) + " USD");
        convert.accept(money);
    }

    static String reverseString() {
        //Fifth task
        Supplier<String> reverse = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите строку которую хотите развернуть");
            StringBuilder sb = new StringBuilder(scanner.nextLine());
            return sb.reverse().toString();
        };
        return reverse.get();
    }
}