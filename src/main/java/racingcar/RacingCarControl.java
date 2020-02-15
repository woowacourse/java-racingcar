package racingcar;

import racingcar.domain.CarsInOneRace;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarControl {
    public static void run() {
        CarsInOneRace carsInOneRace = new CarsInOneRace(InputView.getNames());
        int moveNumber = InputView.getMoveNumber();
        OutputView.printResultTitle();

        for(int i = 0; i < moveNumber; i++) {
            carsInOneRace.move();
            OutputView.printStatus(carsInOneRace.getCars());
        }

        OutputView.printWinners(carsInOneRace.getWinners());
    }
}
