package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Winner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Output {
    private static final String SEPERATOR = ", ";
    private static final String MOVE_INDICATOR = "-";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEachTryCarDistance(List<Car> cars, int index) {
        cars.forEach(car ->
                System.out.println(car.getName() + " : " + MOVE_INDICATOR.repeat(car.getDistanceRecord(index))));
        System.out.println();
    }

    public static void printEachCarResult(List<Car> cars, int tryCount) {
        printMessage("실행 결과");
        for (int index = 0; index < tryCount; index++) {
            printEachTryCarDistance(cars, index);
        }
    }

    public static void printWinner(Winner winner) {
        String winnerNames = winner.getWinnerNames().stream()
                .map(Objects::toString)
                .collect(Collectors.joining(SEPERATOR));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
