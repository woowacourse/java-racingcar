import domain.Car;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static util.StringUtils.*;

public class CarRacingGame {
    private static final int BOUND_NUMBER = 10;

    public static void main(String[] args) {
        String names = InputView.inputCarNames();
        List<Car> cars = readyCarForRacing(names);
        int tryNum = InputView.inputTryNum();

        System.out.println("\n실행 결과");
        startRacing(cars, tryNum);

        OutputView.printWinner(cars);
    }

    private static List<Car> readyCarForRacing(String names) {
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

    private static void tryMove(List<Car> cars) {
        for (Car car : cars) {
            car.judgeMove(getRandomNumber());
        }
    }

    private static void startRacing(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i ++) {
            tryMove(cars);
            OutputView.printTrace(cars);
        }
    }
}
