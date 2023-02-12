package racingcar.domain;

public class GameRound {
    private final int totalRound;
    private int currRound;

    public GameRound(int totalRound) {
        this.totalRound = totalRound;
        this.currRound = 0;
    }

    public void increaseRound() {
        this.currRound++;
    }

    public boolean isEnd() {
        return this.currRound == this.totalRound;
    }
}
