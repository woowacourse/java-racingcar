package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDto;
import racingcar.domain.strategy.MovePredicate;
import racingcar.domain.util.CarFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public static void run() {
        Game game = new Game(CarFactory.of(InputView.inputCarNames()), InputView.inputGameCount());
        play(game);
        showWinner(game.getWinners());
    }

    private static void play(Game game) {
        OutputView.printGameResultTitle();
        while (!game.isEnd()) {
            game.play(new MovePredicate());
            showResult(game);
        }
    }

    private static void showResult(Game game) {
        OutputView.printCarPosition(CarDto.of(game.getCars()));
        OutputView.printBlankLine();
    }

    private static void showWinner(List<Car> winners) {
        OutputView.printWinner(CarDto.of(winners));
    }
}
