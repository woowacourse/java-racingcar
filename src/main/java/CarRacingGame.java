import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static util.StringUtils.*;

public class CarRacingGame {
    private static int BOUND_NUMBER = 10;

    private static List<String> getCarNames() {
        String names = InputView.inputCarNames();
        List<String> nameList = parseStringByComma(names);

        for (String name : nameList) {
            if (!isCarNameLength(name)) {
                System.out.println("각 자동차의 이름을 5자 이하로 입력해주세요.");
                return getCarNames();
            }
        }
        return nameList;
    }

    private static int getTryNum() {
        String input = InputView.inputTryNum();

        if (!isNumberString(input)) {
            System.out.println("숫자로 입력해주세요.");
            return getTryNum();
        }
        return Integer.parseInt(input);
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

    private static List<Car> registerCar(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void startRacing(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i ++) {
            tryMove(cars);
            OutputView.printTrace(cars);
        }
    }

    public static void main(String[] args) {
        List<String> names = getCarNames();
        List<Car> cars = registerCar(names);
        int tryNum = getTryNum();

        System.out.println("\n실행 결과");
        startRacing(cars, tryNum);

        OutputView.printWinner(cars);
    }
}
