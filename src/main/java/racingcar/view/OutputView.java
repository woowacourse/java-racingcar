package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Winners;

public class OutputView {

    private static final String ERROR_FORMAT = "[ERROR] ";
    private static final String RESULT_TITLE = "실행결과";

    private OutputView() {
        throw new IllegalStateException("OutputView can't be initialized because it is a view");
    }

    public static void printResultTitle() {
        System.out.println(System.lineSeparator() + RESULT_TITLE);
    }

    public static void printRoundResult(final Cars cars) {
        System.out.println();
        for (Car car : cars.toList()) {
            System.out.println(car.getName() + " : " + getVisualPosition(car));
        }
    }

    private static String getVisualPosition(final Car car) {
        StringBuilder visualPosition = new StringBuilder();
        for (int i = 0; i < car.getPosition(); ++i) {
            visualPosition.append("-");
        }
        return visualPosition.toString();
    }

    public static void printFinalResult(final Winners winnerCars) {
        String winners = winnerCars.toList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(System.lineSeparator() + winners + "가 최종 우승했습니다.");
    }

    public static void printError(Exception e) {
        System.out.println(System.lineSeparator() + ERROR_FORMAT + e.getMessage());
    }
}
