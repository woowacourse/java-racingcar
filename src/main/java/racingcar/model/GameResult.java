package racingcar.model;

import java.util.List;

public record GameResult(List<GameStatus> status, GameWinners winners) {
}
