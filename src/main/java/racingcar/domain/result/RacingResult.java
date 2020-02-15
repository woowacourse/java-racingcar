package racingcar.domain.result;

import racingcar.domain.Referee;
import racingcar.domain.car.Car;

import java.util.List;

public class RacingResult {
    private static final String DIVIDER = " : ";
    private static final String MARK = "-";
    private static final String ENTER = "\n";

    private final List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(car);
            stringBuilder.append(DIVIDER);
            stringBuilder.append(multiply(car.getPosition(), MARK));
            stringBuilder.append(ENTER);
        }

        return stringBuilder.toString();
    }

    private String multiply(int position, String mark) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append(mark);
        }

        return stringBuilder.toString();
    }

    public List<Car> getWinners() {
        return Referee.getWinners(cars);
    }
}
