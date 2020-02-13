package racingcar.application;

import racingcar.domain.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = generateCarRacing();
        run(carRacing);
        findWinner(carRacing);
    }

    private static CarRacing generateCarRacing() {
        try {
            return new CarRacing(InputView.getNames(), InputView.getMoveNumber());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateCarRacing();
        }
    }

    private static void run(CarRacing carRacing) {
        System.out.println("\n실행 결과");
        for(int i = 0; i < carRacing.getMoveNumber(); i++) {
            carRacing.move();
            OutputView.printStatus(carRacing.getCars());
            System.out.println();
        }
    }

    private static void findWinner(CarRacing carRacing) {
        OutputView.printWinners(carRacing.getWinners());
    }
}
