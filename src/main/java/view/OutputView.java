package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DASH = "-";

    private OutputView() {
    }

    public static void printRoundResult(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(generateResult(car));
        }
        System.out.println();
    }

    public static void printResultNotice() {
        System.out.println("실행 결과");
    }

    public static void printWinners(final List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println(winners + "가 최종 우승했습니다.");
    }


    private static String generateResult(final Car car) {
        return String.join(" : ", car.getCarName(), DASH.repeat(car.getDistance()));
    }
}
