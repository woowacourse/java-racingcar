package dto;

import java.util.List;
import racingcar.vo.Name;

public class Winners {
    private final List<Name> winners;

    public Winners(List<Name> winners) {
        this.winners = winners;
    }

    public List<Name> getWinners() {
        return winners;
    }
}
