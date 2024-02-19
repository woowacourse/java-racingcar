package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class TestOutputView implements OutputView {
    private static final String POSITION_FORM = "%s: %d";

    public void printCarPosition(final Cars cars) {
        for(Car car : cars.getCars()) {
            final String name = car.getName();
            final int movementCount = car.getMovement();
            System.out.println(String.format(POSITION_FORM, name, movementCount));
        }
    }

    public void printWinners(final List<Car> winners) {
        System.out.print("[경주의 우승자] ");
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        System.out.println(String.join(", ", winnerNames));
    }

    public void printResultMsg() {
    }
}
