package view;

import domain.Car;
import domain.Cars;
import domain.Name;
import domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DELIMITER = "-";
    private static final String SEPARATOR = ", ";
    private static final String WINNER_MSG = "%s가 최종 우승했습니다.";
    private static final String FORMAT = "%s : %s";

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printAllCars(Cars cars) {
        for (Car car : cars) {
            printCurrentState(car);
        }
        System.out.println();
    }

    public static void printCurrentState(Car car) {
        System.out.println(String.format(FORMAT, car.getName(), drawResult(car.getPosition())));
    }

    public static void printWinners(Cars cars) {
        List<Name> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
        }

        String winners = carNames.stream()
                .map(m -> m.toString())
                .collect(Collectors.joining(SEPARATOR));

        System.out.println(String.format(WINNER_MSG, winners));
    }

    public static String drawResult(Position position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            stringBuilder.append(DELIMITER);
        }
        return stringBuilder.toString();
    }
}
