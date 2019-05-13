import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class CarRacingGame {
    public static List<Car> readyCarForRacing(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            try {
                cars.add(new Car(name));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return readyCarForRacing(InputView.inputCarNames());
            }
        }
        return cars;
    }

    public static void tryMove(List<Car> cars) {
        for (Car car : cars) {
            CarRacingRule.judgeMove(car, CarRacingRule.getRandomNumber());
        }
    }

    public static void startRacing(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i ++) {
            tryMove(cars);
            OutputView.printTrace(cars);
        }
    }
}
