package racingcar;

import java.util.*;

public class CarGameLauncher {
    public static void main(String[] args) {
        doCarGame();
    }

    private static void doCarGame() {
        List<String> listOfCarNames = Car.askCarNames();
        int totalTurns = Car.askTotalTurns();
        Cars cars = new Cars(listOfCarNames);
        cars.printTheProcess(totalTurns);
        Winners winners = new Winners();
        winners.decideWinners(cars);
        winners.printWinners();
    }
}
