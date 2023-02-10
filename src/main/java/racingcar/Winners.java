package racingcar;

import java.util.List;

public class Winners {

    private final List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public List<Winner> getWinners() {
        return winners;
    }
}
