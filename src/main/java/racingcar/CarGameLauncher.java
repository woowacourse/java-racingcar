package racingcar;

import racingcar.view.InputView;

import java.util.*;

public class CarGameLauncher {
    public static void main(String[] args) {
        doCarGame();
    }

    public static void doCarGame() {
        List<String> carNames = InputView.askAndReceiveCarNames();
        Cars cars = new Cars(carNames);
        int totalTurns = InputView.askAndReceiveTotalTurns();
        cars.printTheProcess(totalTurns);
        Winners winners = new Winners();
        winners.decideWinners(cars);
        winners.printWinners();
    }
}
