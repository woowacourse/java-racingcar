package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public RacingCarController() {
    }

    public void run() {
        final RacingCars racingCars = new RacingCars(InputView.getCarNames(), new RacingCarCommander());
        final int tryCount = InputView.inputTryCount();

        final RacingGame game = new RacingGame(racingCars, tryCount);
        OutputView.printGameResultTitle();
        raceAllRounds(game, racingCars);
        OutputView.printWinnerNames(game.getWinnerNames());
    }

    public void raceAllRounds(final RacingGame game, final RacingCars racingCars) {
        while (!game.isEnd()) {
            game.race();
            OutputView.printCarsPosition(convertToRacingCarDtos(racingCars.getCars()));
        }
    }

    private List<RacingCarDto> convertToRacingCarDtos(final List<RacingCar> cars) {
        return RacingCarDto.from(cars);
    }
}
