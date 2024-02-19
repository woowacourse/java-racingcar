package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printCarsPosition(final List<Car> cars) {
        cars.forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(final Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(final List<String> winners) {
        final String winnerJoining = String.join(", ", winners);
        System.out.printf("%s가 최종 우승했습니다.", winnerJoining);
    }

    public void printError(final String message) {
        System.out.println(message);
    }
}
