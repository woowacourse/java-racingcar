package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> cars;
    private Car carWithMaxDistance;

    public Winner(List<Car> cars, Car carWithMaxDistance) {
        this.cars = cars;
        this.carWithMaxDistance = carWithMaxDistance;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).isMaxPosition(carWithMaxDistance)) {
                winnerNames.add(cars.get(i).getName());
            }
        }

        return winnerNames;
    }
}
