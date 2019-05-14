package racingcar;

import racingcar.model.RacingGame;
import racingcar.model.WinningCars;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        String[] carNames = View.inputNameOfCar();
        String numberOfTry = View.inputNumberOfTry();

        RacingGame racingGame = new RacingGame(carNames, numberOfTry);
        View.outputLine("실행 결과");
        for (int i = 0; i < Integer.parseInt(numberOfTry); i++) {
            racingGame.moveCars();
            View.printCars(racingGame);
        }
        View.printWinningCars(racingGame.getWinnerCars());
    }
}
