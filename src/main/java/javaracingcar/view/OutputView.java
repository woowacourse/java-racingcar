package javaracingcar.view;

import javaracingcar.domain.Car;
import javaracingcar.domain.Game;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    public static void printResultTitle() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public static void printRoundResult(Game game) {
        game.getCars()
            .forEach(OutputView::printRoundResult);
        System.out.println();
    }

    private static void printRoundResult(Car car) {
        System.out.println(car.getName() + " : " + printPositionResult(car.getPosition()));
    }

    private static String printPositionResult(int position) {
        StringBuilder positionResult = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionResult.append("-");
        }
        return positionResult.toString();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                                          .map(Car::getName)
                                          .collect(Collectors.toList());
        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
