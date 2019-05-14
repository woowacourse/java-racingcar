package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        String[] carNames = View.inputNameOfCar();
        int numberOfTry = View.inputNumberOfTry();

        RacingGame racingGame = new RacingGame(carNames, numberOfTry);
        racingGame.playGame();
        View.outputLine("실행 결과");
        View.outputLine(racingGame.result());
        View.printWinningCars(racingGame.getWinnerCars());
    }
}
