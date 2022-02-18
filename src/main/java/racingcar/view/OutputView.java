package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.model.Car;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COMMA = ", ";

    private OutputView() {
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(final List<Car> cars) {
        cars.forEach(car -> System.out.println(createResultString(car)));
        System.out.println();
    }

    private static String createResultString(final Car car) {
        return car.getCarName() + COLON + progress(car.getPosition());
    }

    private static String progress(final int position) {
        return IntStream.range(0, position)
            .mapToObj(i -> DASH)
            .collect(Collectors.joining());
    }

    public static void printWinners(final List<Car> winners) {
        System.out.println(WINNER_MESSAGE + createWinners(winners));
    }

    private static String createWinners(final List<Car> winners) {
        List<String> names = winners.stream()
            .map(Car::getCarName)
            .collect(Collectors.toList());

        return String.join(COMMA, names);
    }
}
