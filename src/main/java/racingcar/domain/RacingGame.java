package racingcar.domain;

import java.util.List;
import racingcar.controller.RacingCarDto;

public class RacingGame {

    private final RacingCars racingCars;
    private final Round finalRound;
    private Round currentRound = Round.init();

    public RacingGame(final RacingCars racingCars, final Round finalRound) {
        this.racingCars = racingCars;
        this.finalRound = finalRound;
    }

    public void race() {
        currentRoundToNextRound();
        racingCars.moveCars();
    }

    private void currentRoundToNextRound() {
        checkCanRace();
        currentRound = currentRound.nextRound();
    }

    private void checkCanRace() {
        if (isEnd()) {
            throw new IllegalStateException("종료된 게임은 더이상 실행할 수 없다.");
        }
    }

    public List<String> winnerNames() {
        checkCanReturnWinner();
        return racingCars.calculateWinnerNames();
    }

    private void checkCanReturnWinner() {
        if (!isEnd()) {
            throw new IllegalStateException("종료되지 않은 게임은 우승자를 반환할 수 없다.");
        }
    }

    public boolean isEnd() {
        return currentRound.compareTo(finalRound) > 0;
    }

    public List<RacingCarDto> getCurrentRacingCarDtos() {
        return racingCars.getRacingCarDtos();
    }
}
