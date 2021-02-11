package racingcar.domain.game;

public class Game {

    private final Round round;

    private Game(final Round round) {
        this.round = round;
    }

    public Game(final String round) {
        this.round = new Round(round);
    }

    public Game(final int round) {
        this(new Round(round));
    }

    public boolean play() {
        return round.playRound();
    }

    public boolean notFinished() {
        return !round.allRoundPlayed();
    }
}
