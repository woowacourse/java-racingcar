package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class CarGameLauncher {
    public static void main(String[] args) {
        doCarGame();
    }

    public static void doCarGame() {
        List<String> carNames = InputView.askAndReceiveCarNames();
        Cars cars = new Cars(carNames);
        int totalTurns = InputView.askAndReceiveTotalTurns();
        OutputView.printTheProcess(cars, totalTurns);
        Winners winners = new Winners();
        winners.decideWinners(cars);
        OutputView.printWinners(winners);
    }
}
