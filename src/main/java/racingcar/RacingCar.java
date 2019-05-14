package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        String[] carNames = View.inputNameOfCar();
        int numberOfTry = View.inputNumberOfTry();

        RacingGame racingGame = new RacingGame(carNames, numberOfTry);
        View.outputLine("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            racingGame.moveCars();
            View.printCars(racingGame);
        }
        View.printWinningCars(racingGame.getWinnerCars());
    }
}
