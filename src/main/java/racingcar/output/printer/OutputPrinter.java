package racingcar.output.printer;

import static racingcar.input.utils.carname.CarNamesSplitterUtils.CAR_NAMES_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;

public class OutputPrinter {
    private static final String NEW_LINE = "\n";
    private static final String POSITION_SIGN = "-";

    private OutputPrinter() {
    }

    public static void printStartMessageOfAllCarRacing() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public static void printCurrentPositionStateOfCar(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_SIGN);
        }

        printNewLine();
    }

    public static void printWinners() {
        List<Car> winners = CarRepository.getWinners();
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.print(String.join(CAR_NAMES_DELIMITER + " ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printNewLine() {
        System.out.print(NEW_LINE);
    }
}
