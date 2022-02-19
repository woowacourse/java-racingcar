package racingcar;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDto;
import racingcar.domain.strategy.RandomMove;
import racingcar.domain.util.CarFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public static void run() {
        Game game = new Game(new Cars(CarFactory.of(InputView.inputCarNames())));
        final int count = InputView.inputGameCount();
        play(game, count);
        showWinner(game.getWinners());
    }

    private static void play(Game game, int count) {
        OutputView.printGameResultTitle();
        for (int i = 0; i < count; i++) {
            showResult(game.play(new RandomMove()));
        }
    }

    private static void showResult(Cars cars) {
        OutputView.printCarPosition(CarDto.of(cars));
        OutputView.printBlankLine();
    }

    private static void showWinner(List<Car> winners) {
        OutputView.printWinner(CarDto.of(winners));
    }
}
