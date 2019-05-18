package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winners = new ArrayList<>();

    public Winners(List<Car> cars) {
        List<Car> winners = Judge.decideWinners(cars);
        this.winners = winners;
    }

    public List<String> getWinnersNames() {
        List<String> winnersNames = new ArrayList<>();
        for (Car currentWinner : winners) {
            winnersNames.add(currentWinner.getName());
        }
        return winnersNames;
    }
}
