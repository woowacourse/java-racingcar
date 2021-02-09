package racingcar.domain.game;

import java.util.Objects;

public class Game {

    private final Round round;

    public Game(final int round) {
        this.round = new Round(round);
    }

    public Game(final String round) {
        this.round = new Round(round);
    }

    public void play() {
        round.playRound();
    }

    public boolean notFinished() {
        return !round.allRoundPlayed();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Game game = (Game) o;
        return round.equals(game.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
