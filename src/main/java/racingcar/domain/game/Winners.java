package racingcar.domain.game;

import racingcar.domain.car.CarName;

import java.util.List;

public class Winners {
    private final List<CarName> winners;

    public Winners(List<CarName> winners) {
        this.winners = winners;
    }

    public List<CarName> getWinners() {
        return winners;
    }
}
