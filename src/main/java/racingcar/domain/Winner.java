package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> cars;
    private int maxDistance;

    public Winner(List<Car> cars, int maxDistance) {
        this.cars = cars;
        this.maxDistance = maxDistance;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).isMaxPosition(maxDistance)) {
                winnerNames.add(cars.get(i).getName());
            }
        }

        return winnerNames;
    }
}
