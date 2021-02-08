package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import racingcar.view.OutputView;

public class Cars {

    private static final int BOUND = 10;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(Random random) {
        for (Car car : cars) {
            car.move(random.nextInt(BOUND));
            OutputView.printCarStateMessage(car.getName(), car.positionToString());
        }
        OutputView.printNextLine();
    }

    public List<String> getWinners() {
        int maxPosition = findWinnerPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car, maxPosition, winners);
        }
        return winners;
    }

    private int findWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private void addWinner(Car car, int maxPosition, List<String> winners) {
        if (maxPosition == car.getPosition()) {
            winners.add(car.getName());
        }
    }
}