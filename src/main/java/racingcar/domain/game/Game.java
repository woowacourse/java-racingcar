package racingcar.domain.game;

public class Game {

    private final Round round;

    public Game(int round) {
        this.round = new Round(round);
    }

    public Game(String round) {
        this.round = new Round(round);
    }

    public void play() {
        round.playRound();
    }

    public boolean notFinished() {
        return !round.allRoundPlayed();
    }
}
