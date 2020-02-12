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
        System.out.println("\n실행 결과");

        for(int i = 0; i < moveNumber; i++) {
            carRacing.move();
            OutputView.printStatus(carRacing.getCars());
            System.out.println();
        }

        OutputView.printWinners(carRacing.getWinners());
    }
}
