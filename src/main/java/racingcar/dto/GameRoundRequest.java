package racingcar.dto;

public class GameRoundRequest {
    private final int round;

    public GameRoundRequest(int gameRound) {
        round = gameRound;
    }

    public int getRound() {
        return round;
    }
}
