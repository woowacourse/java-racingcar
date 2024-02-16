package racingcar.controller;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Round;
import racingcar.util.ExceptionRoofer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Cars cars = getCars();
        final Round round = getRound();

        play(round, cars);

        outputView.printCarsPosition(createCarDtos(cars));

        final List<String> winnersName = findWinnersName(cars);
        outputView.printWinners(winnersName);
    }

    private Cars getCars() {
        return ExceptionRoofer.generate(this::supplyCars, outputView::printError);
    }

    private Cars supplyCars() {
        final String names = inputView.readCarNames();
        return Cars.from(names);
    }

    private Round getRound() {
        return ExceptionRoofer.generate(this::supplyRound, outputView::printError);
    }

    private Round supplyRound() {
        final String tryRound = inputView.readTryRound();
        return Round.from(tryRound);
    }

    private void play(final Round round, final Cars cars) {
        final RandomNumberGenerator generator = new RandomNumberGenerator();

        while (round.isContinue()) {
            cars.go(generator);
            round.progress();

            final List<CarDto> carDtos = createCarDtos(cars);

            outputView.printCarsPosition(carDtos);
        }
    }

    private List<String> findWinnersName(final Cars cars) {
        return cars.findWinner()
                .stream()
                .map(Car::getName)
                .toList();
    }

    private List<CarDto> createCarDtos(final Cars cars) {
        return cars.getCars()
                .stream()
                .map(CarDto::from)
                .toList();
    }

}
