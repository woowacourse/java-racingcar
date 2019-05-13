package racingcar;

import racingcar.model.RacingGame;
import racingcar.model.WinningCars;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        RacingGame racingGame = makeCars(View.inputNameOfCar()
                , View.inputNumberOfTry());

        View.printResultStart();
        while (racingGame.checkNumberOfTry()) {
            moveCar(racingGame);
            View.printCars(racingGame);
        }
        View.printWinningCars(getWinningCars(racingGame));
    }

    private static RacingGame makeCars(String[] carNames, int numberOfTry) {
        return new RacingGame(carNames, numberOfTry);
    }

    private static void moveCar(RacingGame racingGame) {
        racingGame.moveCars();
    }

    private static WinningCars getWinningCars(RacingGame racingGame) {
        return racingGame.getWinnerCars();
    }
}
