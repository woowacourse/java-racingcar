package domain;

import java.util.List;

public class Winners {
    private final List<String> winnerNames;

    private Winners(List<String> winners) {
        this.winnerNames = winners;
    }

    public static Winners from(RandomMovingCars randomMovingCars) {
        return new Winners(randomMovingCars.findWinnerNames());
    }

    public List<String> getWinners() {
        return winnerNames;
    }
}
