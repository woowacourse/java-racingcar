package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public static void raceStart(List<Car> cars, int tryNum) {
        Output.printStartRace();
        for (int i = 0; i < tryNum; i++) {
            move(cars);
            Output.racePrint(cars);
        }
    }

    private static void move(List<Car> cars) {
//        for (Car car : cars) {
//            car.goForward();
//        }
    }

    public static void finalWinner(List<Car> cars) {
        Output.winnerPrint(getWinnerList(cars));
    }

    private static List<String> getWinnerList(List<Car> cars) {
        List<String> winnerList = new ArrayList<>();
//        int winnerPosition = Car.getWinnerPosition(cars);

//        for (Car car : cars) {
//            if (car.isWinner(winnerPosition)) {
//                winnerList.add(car.getName());
//            }
//        }

        return winnerList;
    }
}
