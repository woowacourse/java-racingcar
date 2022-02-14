package racingcar;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarOutput;

public class RacingCarMain {
    public static void main(String[] args) {
        List<Car> cars = RacingCarInput.carNameInput();
        int round = RacingCarInput.roundInput();
        RacingGame racingGame = new RacingGame(cars);
        RacingCarOutput.printRoundResultMessage();
        raceAndPrintResult(round, racingGame);
        RacingCarOutput.printWinners(racingGame.findWinners());
    }

    private static void raceAndPrintResult(int round, RacingGame racingGame) {
        for (int i = 0; i < round; i++) {
            List<Car> raceResult = racingGame.race();
            RacingCarOutput.printRoundResult(raceResult);
        }
    }
}
