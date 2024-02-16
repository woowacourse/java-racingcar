package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    public static void printResultNotice() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundsResult(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(generateResult(car));
            result.append("\n");
        }
        System.out.println(result);
    }

    private static String generateResult(final Car car) {
        String distance = "-";
        return car.getCarName()
                + " : "
                + distance.repeat(car.getDistance());
    }

    public static void printWinners(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
