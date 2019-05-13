package racingcar.domain.result;

import racingcar.domain.RacingGamePlayers;

import java.util.List;

public class RacingGameRound {
    private RacingGamePlayers players;

    public RacingGameRound(RacingGamePlayers players) {
        this.players = players.clone();
    }

    public List<String> getNamesOfWinners() {
        return players.getNamesOfWinners();
    }

    @Override
    public String toString() {
        return players.toString();
    }
}
