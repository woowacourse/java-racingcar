package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winnerNames;

    public Winner(List<Car> cars, Car carWithMaxDistance) {
        winnerNames = new ArrayList<>();

        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).isMaxPosition(carWithMaxDistance)) {
                winnerNames.add(cars.get(i).getName());
            }
        }
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
