package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import racingcar.view.OutputView;

public class Cars {
    private List<Car> cars;
    private static final int BOUND = 10;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(Random random) {
        for(Car car : cars) {
            car.move(random.nextInt(BOUND));
            OutputView.printCarStateMessage(car.getName(), car.positionToString());
        }
        OutputView.printNextLine();
    }

    public String getWinners() {
        HashMap<Integer, List<String>> carPositionHashMap = new HashMap<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = findWinnerPosition(car, carPositionHashMap, maxPosition);
        }
        List<String> winners = carPositionHashMap.get(maxPosition);
        return getWinnerNames(winners);
    }
}