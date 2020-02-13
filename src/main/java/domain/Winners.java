package domain;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public int getSize() {
        return winners.size();
    }

    public Car getWinner(int index) {
        return winners.get(index);
    }
}
