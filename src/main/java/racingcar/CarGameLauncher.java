package racingcar;

import racingcar.view.InputView;
import racingcar.view.InputViewException;
import racingcar.view.OutputView;

public class CarGameLauncher {
    public static void main(String[] args) {
        doCarGame();
    }

    public static void doCarGame() {
        String names = InputView.askAndReceiveCarNames();
        int totalTurns = InputViewException.askAndReceiveTotalTurns();
        Play play = new Play(names);
        OutputView.printResult();
        for (int i = 0; i < totalTurns; i++) {
            OutputView.printState(play.moveCarState());
        }
        OutputView.printWinners(play.getWinners());
        System.exit(0);
    }
}
