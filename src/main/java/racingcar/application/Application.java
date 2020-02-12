package racingcar.application;

import racingcar.domain.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = enterNames();
        Integer moveNumber = enterMoveNumber();

        run(carRacing, moveNumber);
    }

    private static CarRacing enterNames() {
        try {
            return new CarRacing(InputView.getNames());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterNames();
        }
    }

    private static int enterMoveNumber() {
        try {
            return InputView.getMoveNumber();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterMoveNumber();
        }
    }

    private static void run(CarRacing carRacing, int moveNumber) {
        System.out.println("\n실행 결과");
        for(int i = 0; i < moveNumber; i++) {
            carRacing.move();
            OutputView.printStatus(carRacing.getCars());
            System.out.println();
        }
        OutputView.printWinners(carRacing.getWinners());
    }
}
