package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
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
        List<Car> cars = createCars();
        RacingGame racingGame = createRacingGame(cars);

        inputView.finishReadingInput();

        runGame(racingGame);
        showWinner(racingGame);
    }

    private List<Car> createCars() {
        List<String> carNames = inputView.readCarNames();
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private RacingGame createRacingGame(List<Car> cars) {
        int numberOfRaces = inputView.readNumberOfRaces();
        return new RacingGame(cars, numberOfRaces);
    }

    private void runGame(RacingGame racingGame) {
        List<RaceResult> raceResults = racingGame.startRace();
        outputView.printRaceResult(raceResults);
    }

    private void showWinner(RacingGame racingGame) {
        List<Car> winners = racingGame.selectWinner();
        outputView.printWinnerInfo(winners);
    }
}
