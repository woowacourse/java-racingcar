package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static final int START_PLAY_ROUND = 0;

    public static void main(String[] args) {
        String[] carNames = InputView.getRacingCarNames();
        int playRound = InputView.getRacingRound();
        Cars racingCars = new Cars(RacingGame.generateCars(carNames));

        for (int i = START_PLAY_ROUND; i < playRound; i++) {
            RacingGame.startRace(racingCars.getRacingCarList());
            OutputView.printRoundResult(racingCars.getRacingCarList());
            System.out.println();
        }

        OutputView.printWinners(RacingGame.resultRacingGame(racingCars.getRacingCarList()));
    }
}
