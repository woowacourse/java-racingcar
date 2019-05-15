package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> cars;
    private Car carWithMaxPosition;

    public Winner(List<Car> cars, Car carWithMaxPosition) {
        this.cars = cars;
        this.carWithMaxPosition = carWithMaxPosition;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).isMaxPosition(carWithMaxPosition)) {
                winnerNames.add(cars.get(i).getName());
            }
        }

        return winnerNames;
    }
}
