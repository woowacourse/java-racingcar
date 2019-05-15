package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> cars;
    private Car carWithMaxPosision;

    public Winner(List<Car> cars, Car carWithMaxPosision) {
        this.cars = cars;
        this.carWithMaxPosision = carWithMaxPosision;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).isMaxPosition(carWithMaxPosision)) {
                winnerNames.add(cars.get(i).getName());
            }
        }

        return winnerNames;
    }
}
