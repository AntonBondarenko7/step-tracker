import java.util.Scanner;
import java.util.StringJoiner;

public class StepTracker {
    int [][] days = new int[12][30];
    int stepsTarget = 10000;
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);


    void saveSteps (int month, int day, int steps) {
        days[month][day] = steps;
        System.out.println("Количество шагов за " + (day + 1) + " теперь равно " + days[month][day]);
    }

    int getStepsByDate(int month, int day) {
        return (days[month][day]);
    }

    void getStepsByMonth(int month) {
        for (int i = 0; i < days[0].length - 1; i++) {
            System.out.print((i+1) + " день: " + days[month][i] + ", ");
        }
        System.out.println((days[0].length) + " день: " + days[month][days[0].length - 1]);
    }

    int getStepsSumByMonth(int month) {
        int stepsSum = 0;
        for (int i = 0; i < days[0].length; i++) {
            stepsSum += days[month][i];
        }
        return stepsSum;
    }

    void getMaxStepsCountByMonth(int month) {
        int maxStepsCount = 0;
        for (int i = 0; i < days[0].length; i++) {
            if (maxStepsCount < days[month][i]) {
                maxStepsCount = days[month][i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepsCount);
    }

    void getAverageStepsCountByMonth(int month) {
        int averageStepsCount = 0;
        averageStepsCount = getStepsSumByMonth(month) / days[0].length;
        System.out.println("Среднее количество шагов в месяце: " + averageStepsCount);
    }

    void getDistanceByMonth(int month) {
        double distance = converter.calculateDistance(getStepsSumByMonth(month));
        System.out.println("Пройденная дистанция в месяце: " + distance + " км");
    }

    void getBurnedCaloriesByMonth(int month) {
        double burnedCalories = converter.calculateBurnedCalories(getStepsSumByMonth(month));
        System.out.println("Количество сожженных калорий в месяце: " + burnedCalories + " ккал");
    }

    void changeStepsTarget() {
        System.out.println("Введите новое значение целевого количества шагов");
        stepsTarget = scanner.nextInt();
        System.out.println("Новое значение целевого количества шагов: " + stepsTarget);
    }

    void findBestTargetCompletionSequence(int month) {
        int maxSequence = 0;
        for (int i = 0, currentSequence = 0; i < days[0].length; i++) {
            if (days[month][i] >= stepsTarget) {
                currentSequence++;
            } else if (i == days[0].length - 1 || days[month][i] < stepsTarget) {
                if (currentSequence >= maxSequence) {
                    maxSequence = currentSequence;
                    currentSequence = 0;
                }
            }
        }
        System.out.println("Лучшая серия (в днях): " + maxSequence);
    }
}
