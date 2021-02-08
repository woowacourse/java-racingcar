package racing.controller;

import racing.domain.Cars;
import racing.domain.RacingGameMachine;
import racing.domain.RandomMovingStrategy;
import racing.dto.CarDto;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class RacingController {

    public void run() {
        RacingGameMachine racingGameMachine = initializeRacingGameMachine();
        OutputView.printGameResultHeader();
        while (racingGameMachine.canPlay()) {
            racingGameMachine.race();
            List<CarDto> carDtos = racingGameMachine.getCarDtos();
            OutputView.printRacingTryResult(carDtos);
        }
        List<String> winnerNames = racingGameMachine.findWinnerNames();
        OutputView.printWinnerNames(winnerNames);
    }

    private RacingGameMachine initializeRacingGameMachine() {
        String carNames = InputView.getCarNames();
        Cars cars = Cars.generate(carNames, new RandomMovingStrategy());
        int tryCounts = InputView.getTryCounts();
        return new RacingGameMachine(cars, tryCounts);
    }
}
