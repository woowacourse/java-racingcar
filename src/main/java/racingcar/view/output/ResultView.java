package racingcar.view.output;

import static racingcar.view.input.carname.RawCarNamesInputFromUser.CAR_NAMES_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class ResultView {
    private static final String POSITION_SIGN = "-";

    static {
        printNewLine();
        System.out.println("실행 결과");
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printEachCarCurrentPosition);
        printNewLine();
    }

    private static void printEachCarCurrentPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_SIGN);
        }
        printNewLine();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());

        System.out.print(String.join(CAR_NAMES_DELIMITER + " ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printNewLine() {
        System.out.print("\n");
    }
}
