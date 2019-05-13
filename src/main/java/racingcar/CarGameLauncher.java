package racingcar;

import racingcar.view.InputView;
import racingcar.view.InputViewException;
import racingcar.view.OutputView;

public class CarGameLauncher {
    public static void main(String[] args) {
        doCarGame();
    }

    public static void doCarGame() {
        Cars cars = new Cars(InputView.askAndReceiveCarNames());
        int totalTurns = InputViewException.askAndReceiveTotalTurns();
        Play.printCarState(cars, totalTurns);
        Winners winners = new Winners(cars);
        OutputView.printWinners(winners);
        System.exit(0);
    }
}
