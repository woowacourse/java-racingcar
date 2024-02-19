package domain;

import java.util.List;

public class RacingGame {
    private final RaceCars raceCars;
    private final Count count;

    public RacingGame(RaceCars raceCars, Count count) {
        this.raceCars = raceCars;
        this.count = count;
    }

    public void race() {
        while (count.hasRemain()) {
            raceCars.play();
            count.down();
        }
    }

    public List<Car> judgeWinners() {
        raceCars.sortCarsDes();
        int maxLocation = raceCars.getCar(0).getLastLocation();
        return raceCars.getWinners(maxLocation);
    }
}
