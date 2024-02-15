package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String POSITION_SHAPE = "-";

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), POSITION_SHAPE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        String winnerNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.printf("%s가 최종 우승했습니다.", winnerNames);
    }

    public static void printException(Exception exception) {
        System.out.println("[ERROR] " + exception.getMessage());
        System.out.println();
    }
}
