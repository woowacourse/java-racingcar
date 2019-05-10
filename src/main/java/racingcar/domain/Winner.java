package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winnerNames;

    public Winner(List<Car> cars, int maxDistance) {
        winnerNames = new ArrayList<>();

        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).matchPosition(maxDistance)) {
                winnerNames.add(cars.get(i).getName());
            }
        }
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
