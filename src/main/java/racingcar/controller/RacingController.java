package racingcar.controller;

import java.util.List;
import racingcar.generator.RandomNumberGenerator;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.TotalResult;
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
        Cars cars = createCars();
        RacingGame racingGame = createRacingGame(cars);

        inputView.closeScanner();

        TotalResult totalResult = playRacingGame(racingGame);
        printResult(totalResult);
    }

    private Cars createCars() {
        List<String> carNames = inputView.readCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars, new RandomNumberGenerator());
    }

    private RacingGame createRacingGame(Cars cars) {
        int tryCount = inputView.readTryCount();
        return new RacingGame(tryCount, cars);
    }

    private TotalResult playRacingGame(RacingGame racingGame) {
        return new TotalResult(racingGame.run());
    }

    private void printResult(TotalResult totalResult) {
        outputView.printResult(totalResult);
        outputView.printWinnerInfo(totalResult.selectWinner());
    }
}
