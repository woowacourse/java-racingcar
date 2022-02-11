package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarController {
    private static final String PRINT_RESULT = "실행 결과";

    public static void raceStart(List<Car> carList, int tryNum) {
        System.out.println(PRINT_RESULT);

        for (int i = 0; i < tryNum; i++) {
            move(carList);
            Output.racePrint(carList);
        }
    }

    private static void move(List<Car> carList) {
        for (Car car : carList) {
            car.goForward();
        }
    }

    public static void finalWinner(List<Car> carList) {
        List<String> winnerList = getWinnerList(carList);
        Output.winnerPrint(winnerList);
    }

    private static List<String> getWinnerList(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int winnerPosition = Car.getWinnerPosition(carList);

        for (Car car : carList) {
            if (car.isWinner(winnerPosition)) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
