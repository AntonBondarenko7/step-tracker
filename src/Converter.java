public class Converter {
    double stepLength = 0.00075; // 1 шаг = 75 см = 0.00075 км
    double kcalPerStep = 0.05; // 1 шаг = 50 кал = 0.05 ккал

    double calculateDistance(int steps) {
        return (steps * stepLength);
    }

    double calculateBurnedCalories(int steps) {
        return (steps * kcalPerStep);
    }
}
