package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Cars cars = getCars();
        final Round round = getRound();

        RandomNumberGenerator generator = new RandomNumberGenerator();

        while (!round.isEnd()) {
            cars.go(generator);
            round.progress();

            List<CarDto> carDtos = createCarDtos(cars);

            outputView.printPerRound(carDtos);
        }

        outputView.printPerRound(createCarDtos(cars));

        List<String> winner = cars.findWinner()
                .stream()
                .map(Car::getName)
                .toList();

        outputView.printWinners(winner);
    }

    private Cars getCars() {
        return generate(() -> {
            String names = inputView.readCarNames();
            return Cars.from(names);
        });
    }

    private Round getRound() {
        return generate(() -> {
            String tryRound = inputView.readTryRound();
            Round round = Round.from(tryRound);
            return round;
        });
    }

    private List<CarDto> createCarDtos(Cars cars) {
        return cars.getCars()
                .stream()
                .map(CarDto::from)
                .toList();
    }

    private <T> T generate(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

}
