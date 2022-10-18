import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = 0;
        int month = 0;
        int steps = 0;
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                System.out.println("Введите месяц, за который хотите добавить шаги (0 - Январь, 11 - Декабрь)");
                month = scanner.nextInt();
                while (month < 0 || month > 11) {
                    System.out.println("Месяц должен быть в диапазоне от 0 до 11!");
                    System.out.println("Введите месяц, за который хотите добавить шаги (0 - Январь, 11 - Декабрь)");
                    month = scanner.nextInt();
                }
                System.out.println("Введите день, за который хотите добавить шаги (от 1 до 30)");
                day = scanner.nextInt() - 1;
                while (day < 0 || day > 29) {
                    System.out.println("День должен быть в диапазоне от 1 до 30!");
                    System.out.println("Введите день, за который хотите добавить шаги (от 1 до 30)");
                    day = scanner.nextInt() - 1;
                }
                System.out.println("Введите количество шагов");
                steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Количество шагов должно быть больше 0!");
                    System.out.println("Введите количество шагов");
                    steps = scanner.nextInt();
                }
                stepTracker.saveSteps(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("Введите месяц, за который хотите посмотреть статистику (0 - Январь, 11 - Декабрь)");
                month = scanner.nextInt();
                stepTracker.getStepsByMonth(month);
                int stepsSum = stepTracker.getStepsSumByMonth(month);
                System.out.println("Сумма шагов за месяц: " + stepsSum);
                stepTracker.getMaxStepsCountByMonth(month);
                stepTracker.getAverageStepsCountByMonth(month);
                stepTracker.getDistanceByMonth(month);
                stepTracker.getBurnedCaloriesByMonth(month);
                stepTracker.findBestTargetCompletionSequence(month);
            } else if (userInput == 3) {
                stepTracker.changeStepsTarget();
            } else {
                System.out.println("Такой команды не существует");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");


    }

    public static void printMenu() {
    System.out.println("Что вы хотите сделать?");
    System.out.println("1 - Добавить количество шагов за день");
    System.out.println("2 - Показать статистику");
    System.out.println("3 - Изменить целевое количество шагов");
    System.out.println("0 - Выход");
    }
}