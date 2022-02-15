package racingcar.domain;

import java.util.List;
import racingcar.controller.RacingCarDto;

public class RacingGame {

    private static final int END_COUNT = 0;

    private final RacingCars racingCars;
    private final Round finalRound;
    private Round currentRound = Round.init();

    public RacingGame(final RacingCars racingCars, final Round finalRound, final Round currentRound) {
        this.racingCars = racingCars;
        this.finalRound = finalRound;
        this.currentRound = currentRound;
    }

    public RacingGame(final RacingCars racingCars, final Round finalRound) {
        this.racingCars = racingCars;
        this.finalRound = finalRound;
    }

    public void race() {
        currentRoundToNextRound();
        racingCars.moveCars();
    }

    public boolean isEnd() {
        return currentRound.compareTo(finalRound) > 0;
    }

    private void currentRoundToNextRound() {
        checkCanRace();
        currentRound = currentRound.nextRound();
    }

    private void checkCanRace() {
        if (isEnd()) {
            throw new UnsupportedOperationException("종료된 게임은 더이상 실행할 수 없다.");
        }
    }

    public List<String> winnerNames() {
        return racingCars.calculateWinnerNames();
    }

    public List<RacingCarDto> getCurrentRacingCarDtos() {
        return racingCars.getRacingCarDtos();
    }
}
