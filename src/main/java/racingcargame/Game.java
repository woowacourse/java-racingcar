package racingcargame;

import racingcargame.model.Result;
import racingcargame.model.Round;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

class Game {
    private Result result;
    private int countOfRound;

    private static final String ROUND_RESULT = "실행 결과";

    void play() {
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
        List<Round> rounds = new ArrayList<>();
        for (int i = 0; i < countOfRound; i++) {
            rounds.add(result.roundResult());
        }
        OutputView.printRound(rounds);
    }

    private void endGame() {
        OutputView.printGameResult(result.gameResult());
    }
}
