package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.dto.NumberOfRoundsRequestDTO;

public class GameStatusChecker {
    private final int NumberOfRounds;

    public GameStatusChecker(NumberOfRoundsRequestDTO NumberOfRoundsRequestDTO) {
        this.NumberOfRounds = NumberOfRoundsRequestDTO.getNumberOfRounds();
    }

    public boolean isOngoing(int currentRound) {
        if (currentRound > NumberOfRounds) {
            throw new IllegalArgumentException(ErrorMessage.OVER_FINAL_ROUND_NUMBER.getMessage());
        }
        return NumberOfRounds != currentRound;
    }
}
