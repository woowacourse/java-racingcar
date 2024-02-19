package racingcar.domain.gamewinner;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.GameWinner;

public class RacingGameWinners implements GameWinner {
    private static final String WINNER_DELIMITER = ", ";

    private final List<String> winnerNames;
    public RacingGameWinners(List<String> carNames){
        winnerNames = carNames;
    }

    @Override
    public String showWinner() {
        return winnerNames.stream()
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
