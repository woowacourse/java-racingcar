package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public static final String RESULT_TITLE = "실행 결과";
    public static final String POSITION_MARKER = "-";
    public static final String PRINT_CAR_FORMAT = "%s : %s\n";

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.printf(PRINT_CAR_FORMAT, car.getName(), makePositionString(car.getPosition()));
    }

    private static String makePositionString(Position position) {
        return Stream.generate(() -> POSITION_MARKER)
                .limit(position.getPosition())
                .collect(Collectors.joining());
    }

    public static void printFirstRoundResult(Cars cars) {
        System.out.println(RESULT_TITLE);
        printRoundResult(cars);
    }
}
