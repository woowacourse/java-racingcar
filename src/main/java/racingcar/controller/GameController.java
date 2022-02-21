package racingcar.controller;

import java.util.List;
import java.util.Objects;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RacingCarGame;
import racingcar.util.UserInputConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final MoveStrategy moveStrategy;

    public GameController(final MoveStrategy moveStrategy) {
        if (Objects.isNull(moveStrategy)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. MoveStrategy타입을 사용하세요.");
        }
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        final Cars cars = generateCars();
        final Count count = getCountFromUser();

        final RacingCarGame racingCarGame = new RacingCarGame(cars, count);

        playGame(racingCarGame);
        showResult(racingCarGame);
    }

    private Cars generateCars() {
        try {
            final String carNamesWithDelimiter = InputView.getCarNames();
            final List<Car> cars = UserInputConvertor.convertToCars(carNamesWithDelimiter);
            return new Cars(cars, moveStrategy);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateCars();
        }
    }

    private void showResult(final RacingCarGame racingCarGame) {
        OutputView.printWinners(racingCarGame.getWinners());
    }

    private void playGame(final RacingCarGame racingCarGame) {
        OutputView.printResult(racingCarGame.getCars());
        while (racingCarGame.canPlay()) {
            racingCarGame.playRound();
            OutputView.printResult(racingCarGame.getCars());
        }
    }

    private Count getCountFromUser() {
        try {
            return new Count(InputView.getCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }
}
