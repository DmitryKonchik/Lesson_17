import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        // First Task
        whenYouHas100Birthday();

    }

    static void whenYouHas100Birthday () {
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
    static boolean checkDate (String date) {
        // First Task
        Pattern pattern = Pattern.compile("[0-9]{4}[-/.][0-9]{2}[-/.][0-9]{2}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}