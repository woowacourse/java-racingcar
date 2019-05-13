import domain.Car;

import java.util.Random;

public class CarRacingRule {
    private static final int BOUND_NUMBER = 10;
    private static final int MIN_MOVE_NUMBER = 4;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_NUMBER);
    }

    public static String judgeMove(Car car, int number) {
        if (number >= MIN_MOVE_NUMBER) {
            car.moveForeword();
            return "Go";
        }
        return "Stop";
    }
}
