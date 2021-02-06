package racingcar.view;

import racingcar.constant.Message;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printCarNamesRequest() {
        System.out.println(Message.CAR_NAMES_REQUEST);
    }

    public static void printTimesRequest() {
        System.out.println(Message.TIMES_REQUEST);
    }

    public static void printResultMessage() {
        System.out.println(Message.RESULT_MESSAGE);
    }

    public static void printResult(Cars cars) {
        List<Car> carList = cars.getCars();

        for (Car car : carList) {
            System.out.println(car);
        }
        printNewLine();
    }

    public static void printWinner(Cars cars) {
        List<String> carNames = cars.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.print(String.join(Message.COMMA_WITH_BLANK.toString(), carNames));
        System.out.println(Message.WINNER_MESSAGE);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
