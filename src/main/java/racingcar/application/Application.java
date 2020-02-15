package racingcar.application;

import racingcar.domain.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CarRacing carRacing = new CarRacing(InputView.getNames());
        int moveNumber = InputView.getMoveNumber();
        OutputView.printResultTitle();

        for(int i = 0; i < moveNumber; i++) {
            carRacing.move();
            OutputView.printStatus(carRacing.getCars());
        }

        OutputView.printWinners(carRacing.getWinners());
    }
}
