package racingcargame.view;

import racingcargame.domain.Car;
import racingcargame.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private ResultView() {
    }

    public static void showResult(List<Car> cars) {
        String message = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "", "가 최종 우승했습니다."));
        System.out.println(message);
    }

    public static void showStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + createBar(car.getDistance()));
        }
        System.out.println();
    }

    private static String createBar(int distance) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            bar.append("-");
        }
        return bar.toString();
    }

    public static void showGameStart() {
        System.out.println("실행 결과");
    }
}
