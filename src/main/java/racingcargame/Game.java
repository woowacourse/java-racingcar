package racingcargame;

import racingcargame.model.Result;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class Game {
    private Result result;
    private int countOfRound;

    private static final String ROUND_RESULT = "실행 결과";

    public void play() {
        start();
        round();
        endGame();
    }

    private void start() {
        String names = InputView.readNames();
        result = new Result(names.split(","));
        countOfRound = InputView.readCountOfRound();
    }

    private void round() {
        System.out.println(ROUND_RESULT);
        for (int i = 0; i < countOfRound; i++) {
            OutputView.printRound(result.roundResult());
        }
    }

    private void endGame() {
        OutputView.printGameResult(result.gameResult());
    }
}
