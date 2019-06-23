package racingcargame.view;

import racingcargame.model.Car;
import racingcargame.model.Cars;
import racingcargame.model.Winners;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void printCarMovements(List<Cars> resultCars) {
        for (Cars currentCars : resultCars) {
            printMovementsOfCurrentCars(currentCars);
        }
    }

    private static void printMovementsOfCurrentCars(Cars currentCars) {
        for (Car car : currentCars.getCars()) {
            System.out.print(car.getName() + ":");
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        List<String> names = new ArrayList<>();
        for (Car car : winners.getWinners()) {
            names.add(car.getName());
        }
        String winnersNames = String.join(",", names);
        System.out.println(winnersNames + " 가 우승했습니다!");
    }

    public static void printResultSentence() {
        System.out.println("실행결과");
    }
}
