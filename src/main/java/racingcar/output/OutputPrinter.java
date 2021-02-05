package racingcar.output;

import static racingcar.input.utils.carname.CarNamesSplitterUtils.CAR_NAMES_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.CarRepository;

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
        System.out.print("최종 우승자 : ");
        List<Car> winners = CarRepository.getWinners();
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(String.join(CAR_NAMES_DELIMITER + " ", winnerNames));
    }

    public static void printNewLine() {
        System.out.println(NEW_LINE);
    }
}
