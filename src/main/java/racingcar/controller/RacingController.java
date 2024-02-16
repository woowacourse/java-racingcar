package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
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

        inputView.finishReadingInput();

        TotalResult totalResult = racingGame.run();
        printResult(totalResult);
    }

    private Cars createCars() {
        List<String> carNames = inputView.readCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    private RacingGame createRacingGame(Cars cars) {
        int tryCount = inputView.readTryCount();
        return new RacingGame(tryCount, cars, new RandomNumberGenerator());
    }

    private void printResult(TotalResult totalResult) {
        outputView.printResult(totalResult);
        outputView.printWinnerInfo(totalResult.getWinner());
    }
}
