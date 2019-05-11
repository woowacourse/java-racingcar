package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> winners;

    public Winner(List<Car> cars) {
        this.winners = getWinnerList(cars);
    }

    private List<Car> getWinnerList(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            if (winners.get(0).compareTo(cars.get(i)) == 0) {
                winners.add(cars.get(i));
            }
            if (winners.get(0).compareTo(cars.get(i)) > 0) {
                winners = new ArrayList<>();
                winners.add(cars.get(i));
            }
        }

        return winners;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return winnerNames;
    }
}
