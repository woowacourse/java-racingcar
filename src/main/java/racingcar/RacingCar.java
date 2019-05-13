package racingcar;

import racingcar.model.RacingGame;
import racingcar.model.WinningCars;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        String[] carNames = View.inputNameOfCar();
        String numberOfTry = View.inputNumberOfTry();

        RacingGame racingGame = makeCars(carNames, numberOfTry);
        View.outputLine("실행 결과");
        for (int i = 0; i < Integer.parseInt(numberOfTry); i++) {
            racingGame = playRacing(racingGame);
            View.printCars(racingGame);
        }
        View.printWinningCars(getWinningCars(racingGame));
    }

    private static RacingGame makeCars(String[] carNames, String numberOfTry) {
        return new RacingGame(carNames, numberOfTry);
    }

    private static RacingGame playRacing(RacingGame racingGame) {
        racingGame.moveCars();
        return racingGame;
    }

    private static WinningCars getWinningCars(RacingGame racingGame) {
        return racingGame.getWinnerCars();
    }
}
