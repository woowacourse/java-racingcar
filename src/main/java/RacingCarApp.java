import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarApp {
    private static final int BOUND_NUMBER = 10;

    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int tryNumber = InputView.inputTryNum();

        List<Car> carList = registerCar(carNames);

        startRacing(carList, tryNumber);
        OutputView.printWinnerName(carList);
    }

    private static List<Car> registerCar(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return  carList;
    }

    private static void startRacing(List<Car> carList, int tryNumber) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {
            tryMove(carList);
            OutputView.printPosition(carList);
            System.out.println();
        }
    }

    private static void tryMove(List<Car> carList) {
        for (Car car : carList) {
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
