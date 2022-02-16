package racingcar.controller;

import java.util.Optional;

import racingcar.domain.Count;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final MoveStrategy moveStrategy;
    private Count count;
    private RacingCarGame racingCarGame;

    public GameController(final MoveStrategy moveStrategy) {
        this.moveStrategy = Optional.ofNullable(moveStrategy)
                .orElseThrow(() -> new IllegalArgumentException("null은 사용할 수 없습니다. MoveStrategy타입을 사용하세요."));
    }

    public void run() {
        racingCarGame = generateGame();
        count = getCountFromUser();

        playGame();
        showResult();
    }

    private void showResult() {
        OutputView.printWinners(racingCarGame.getWinners());
    }

    private RacingCarGame generateGame() {
        try {
            final String carNamesWithDelimiter = InputView.getCarNames();
            return new RacingCarGame(carNamesWithDelimiter, moveStrategy);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateGame();
        }
    }

    private void playGame() {
        OutputView.printResult(racingCarGame.getCars());
        for (int i = 0; i < count.get(); i++) {
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
