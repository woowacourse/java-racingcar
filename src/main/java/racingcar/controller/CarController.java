package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarController {
    private static final String PRINT_RESULT = "실행 결과";

    public static void raceStart(List<Car> cars, int tryNum) {
        System.out.println(PRINT_RESULT);

        for (int i = 0; i < tryNum; i++) {
            move(cars);
            Output.racePrint(cars);
        }
    }

    private static void move(List<Car> cars) {
        for (Car car : cars) {
            car.goForward();
        }
    }

    public static void finalWinner(List<Car> cars) {
        Output.winnerPrint(getWinnerList(cars));
    }

    private static List<String> getWinnerList(List<Car> cars) {
        List<String> winnerList = new ArrayList<>();
        int winnerPosition = Car.getWinnerPosition(cars);

        for (Car car : cars) {
            if (car.isWinner(winnerPosition)) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
