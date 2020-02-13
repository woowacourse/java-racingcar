package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 출력 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class OutputView {
    public static final String RESULT_TITLE = "실행 결과";
    public static final String POSITION_MARKER = "-";
    public static final String PRINT_CAR_FORMAT = "%s : %s\n";
    public static final String NAME_DELIMITER = ", ";
    public static final String FINAL_WINNER_FORMAT = "%s가 최종 우승했습니다.";

    public static void printRoundResult(final Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(final Car car) {
        System.out.printf(PRINT_CAR_FORMAT, car.getName(), makePositionString(car.getPosition()));
    }

    private static String makePositionString(final Position position) {
        return Stream.generate(() -> POSITION_MARKER)
                .limit(position.getPosition())
                .collect(Collectors.joining());
    }

    public static void printFirstRoundResult(final Cars cars) {
        System.out.println(RESULT_TITLE);
        printRoundResult(cars);
    }

    public static void printWinnerNames(final List<Name> winnerNames) {
        System.out.printf(FINAL_WINNER_FORMAT, makeWinnerNamesString(winnerNames));
    }

    private static String makeWinnerNamesString(final List<Name> winnerNames) {
        return winnerNames.stream()
                .map(Name::toString)
                .collect(Collectors.joining(NAME_DELIMITER));
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
