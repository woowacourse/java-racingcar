package racing.view;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String COMMA = ", ";

    public static void printProcess(Cars cars) {
        System.out.println("실행 결과");
        printCarsInformation(cars);
    }

    public static void printCarsInformation(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.print(String.format("%s : ", car.getName()));
            printProgressBar(car.getDistance());
        }
        System.out.println();
    }

    private static void printProgressBar(int distance) {
        StringBuilder bars = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            bars.append("-");
        }
        System.out.println(bars.toString());
    }

    public static String combine(Winners winners) {
        List<String> winnersNames = winners.getCars().getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(COMMA, winnersNames);
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.format("%s가 최종 우승했습니다.", combine(winners)));
    }
}
