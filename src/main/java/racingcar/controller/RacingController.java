package racingcar.controller;

import java.util.List;
import racingcar.generator.RandomGenerator;
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
        Cars cars = registerCar();
        RacingGame racingGame = createRacingGame(cars);

        inputView.closeScanner();

        TotalResult totalResult = playRacingGame(racingGame);
        printResult(totalResult);
    }

    private Cars registerCar() {
        List<String> strings = inputView.readCarNames();
        List<Car> cars = strings.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars, new RandomGenerator());
    }

    private RacingGame createRacingGame(Cars cars) {
        int count = inputView.readCount();
        return new RacingGame(count, cars);
    }

    private TotalResult playRacingGame(RacingGame racingGame) {
        return new TotalResult(racingGame.gameStart());
    }

    private void printResult(TotalResult totalResult) {
        outputView.printResult(totalResult);
        outputView.printWinnerInfo(totalResult);
    }
}
