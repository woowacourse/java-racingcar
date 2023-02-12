package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String CARS_STATE_FORMAT = "%s : %s"; // ex) name : ---
    private static final String BAR = "-";

    public static void printWinners(Winners winners) {
        System.out.println(String.join(", ", getCarNames(winners.getWinners())) + "가 최종 우승했습니다.");
    }

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getCarStatus(car));
        }
        System.out.println();
    }

    //TODO: 위너의 이름을 리스트로 반환하는 기능을 위너 클래스에 넣어야할지..?
    private static List<String> getCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static String getCarStatus(Car car) {
        return String.format(CARS_STATE_FORMAT,car.getName(),getBars(car.getPosition()));
    }

    private static String getBars(int count) {
        return BAR .repeat(Math.max(0, count));
    }
}
