package domain;

import java.util.Collections;
import java.util.List;

public class Judge {

    private final int MOVING_STANDARD = 4;

    public boolean judgeDriving(int number) {
        return number >= MOVING_STANDARD;
    }

    public List<Car> judgeWinner(Participants participants) {
        List<Car> winners = participants.getWinners();
        return Collections.unmodifiableList(winners);
    }
}
