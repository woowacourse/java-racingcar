package racingCar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCar {
    public static final int START_ROUND = 0;
    private static final int ONE = 1;

    private final Players players;
    private final int totalRound;
    private int round;

    public RacingCar(Players players, int totalRound) {
        this.players = players;
        this.totalRound = totalRound;
        this.round = START_ROUND;
    }

    public void race(DeciderFactory deciderFactory) {
        for (Player t : players.getUnmodifiableList()) {
            t.goOrWait(deciderFactory.create());
        }
        round += ONE;
    }

    public boolean isEnd() {
        return round >= totalRound;
    }

    public int getRound() {
        return round;
    }

    public List<String> getWinners() {
        return players.getWinners().stream()
                .map(Player::getName)
                .map(Name::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getPlayerNames() {
        return players.getUnmodifiableList().stream()
                .map(Player::getName)
                .map(Name::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getPlayerPositions() {
        return players.getUnmodifiableList().stream()
                .map(Player::getPosition)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return totalRound == racingCar.totalRound &&
                round == racingCar.round &&
                Objects.equals(players, racingCar.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, totalRound, round);
    }
}