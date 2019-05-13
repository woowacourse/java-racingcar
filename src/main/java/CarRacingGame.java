import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static util.StringUtils.*;

public class CarRacingGame {
    private static final int BOUND_NUMBER = 10;

    public static List<Car> readyCarForRacing(String names) {
        List<String> nameList = parseStringByComma(names);
        List<Car> cars = new ArrayList<>();

        for (String name : nameList) {
            try {
                cars.add(new Car(name));
            } catch (IllegalArgumentException e) {
                readyCarForRacing(InputView.inputCarNames());
            }
        }
        return cars;
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(BOUND_NUMBER);
    }

    public static void tryMove(List<Car> cars) {
        for (Car car : cars) {
            car.judgeMove(getRandomNumber());
        }
    }

    public static void startRacing(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i ++) {
            tryMove(cars);
            OutputView.printTrace(cars);
        }
    }
}
