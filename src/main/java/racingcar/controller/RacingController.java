package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceResult;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = createCars(carNames);

        int numberOfRaces = inputView.readNumberOfRaces();
        RacingGame racingGame = createRacingGame(cars, numberOfRaces);

        inputView.finishReadingInput();

        List<RaceResult> raceResults = runGame(racingGame);
        outputView.printRaceResult(raceResults);

        List<Car> winners = showWinner(racingGame);
        outputView.printWinnerInfo(winners);
    }

    private Cars createCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    private RacingGame createRacingGame(Cars cars, int numberOfRaces) {
        return new RacingGame(cars, numberOfRaces);
    }

    private List<RaceResult> runGame(RacingGame racingGame) {
        return racingGame.startRace();
    }

    private List<Car> showWinner(RacingGame racingGame) {
        return racingGame.selectWinner();
    }
}
