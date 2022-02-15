package racingcar;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingCars racingCars = new RacingCars();

        racingCars.join(InputView.askCarName());
        RacingGame racingGame = new RacingGame(racingCars);

        racingGame.playGame(racingCars);

        String winnersName = racingGame.getWinnersName();
        OutputView.printWinners(winnersName);
    }

}
