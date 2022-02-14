package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private static final String PRINT_RESULT = "실행 결과";

    public static void startRace(List<Car> carList, int tryNum) {
        System.out.println(PRINT_RESULT);

        for (int i = 0; i < tryNum; i++) {
            moveCar(carList);
            Output.printRace(carList);
        }
    }

    public static void finalWinner(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);
        List<String> winnerList = getWinnerList(carList, maxPosition);
        Output.printWinner(winnerList);
    }

    private static void moveCar(List<Car> carList) {
        for (Car car : carList) {
            car.goForward();
        }
    }

    private static List<String> getWinnerList(List<Car> carList, int maxPosition) {
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    private static int findMaxPosition(List<Car> carList) {
        int maxNum = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        return maxNum;
    }
}
