package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Participants participants;
    private final PlayTime playTime;

    public RacingGame(String[] participantsCarNames, int playTime) {
        this.participants = new Participants(participantsCarNames);
        this.playTime = new PlayTime(playTime);
    }

    public List<RoundResult> startRacing() {
        List<RoundResult> racingResults = new ArrayList<>();
        while (!playTime.isEnd()) {
            racingResults.add(participants.race());
            playTime.decrease();
        }
        return racingResults;
    }

    public List<Car> findRacingWinners() {
        return participants.findRacingWinners();
    }
}
