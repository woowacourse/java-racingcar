package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private static final String PRINT_RESULT = "실행 결과";

    public static void startRace(List<Car> cars, int tryNum) {
        System.out.println(PRINT_RESULT);

        for (int i = 0; i < tryNum; i++) {
            moveCar(cars);
            Output.printRace(cars);
        }
    }

    public static void finalWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winnerList = getWinnerList(cars, maxPosition);
        Output.printWinner(winnerList);
    }

    private static void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.goForward();
        }
    }

    private static List<String> getWinnerList(List<Car> cars, int maxPosition) {
        List<String> winnerList = new ArrayList<>();

        for (Car car : cars) {
            if (car.checkPosition(maxPosition)) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxNum = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        return maxNum;
    }
}
