package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
        throw new UnsupportedOperationException();
    }

    public static void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            String result = car.getName() + " : ";
            result += makePositionString(car);
            System.out.println(result);
        }
        System.out.println();
    }

    static String makePositionString(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinners(List<Car> winners) {
        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
