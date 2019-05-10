import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;

public class RacingCarApp {
    private static final int BOUND_NUMBER = 10;

    public static void main(String[] args) {
        List<Car> cars = InputView.createCars();
        int tryNumber = InputView.inputTryNum();

        startRacing(cars, tryNumber);
        OutputView.printWinnerName(cars);
    }

    private static void startRacing(List<Car> cars, int tryNumber) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {
            tryMove(cars);
            OutputView.printPosition(cars);
            System.out.println();
        }
    }

    private static void tryMove(List<Car> cars) {
        for (Car car : cars) {
            if (car.judgeMove(makeRandomNumber()) == -1) {
                throw new IllegalArgumentException("잘못된 randomNumber");
            }
        }
    }

    private static int makeRandomNumber() {
        Random random = new Random();

        return random.nextInt(BOUND_NUMBER);
    }
}
