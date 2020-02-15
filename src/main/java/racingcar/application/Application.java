package racingcar.application;

import racingcar.domain.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = generateCarRacing();
        int moveNumber = enterNumberUntilValid();

        run(carRacing, moveNumber);
        findWinner(carRacing);
    }

    private static CarRacing generateCarRacing() {
        while (true) {
            try {
                return new CarRacing(InputView.getNames());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int enterNumberUntilValid() {
        while(true) {
            try {
                int number = InputView.getMoveNumber();
                checkValidNumber(number);
                return number;
            } catch(IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    private static void checkValidNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("양의 정수만 입력이 가능합니다.");
        }
    }

    private static void run(CarRacing carRacing, int moveNumber) {
        System.out.println("\n실행 결과");
        for(int i = 0; i < moveNumber; i++) {
            carRacing.move();
            OutputView.printStatus(carRacing.getCars());
            System.out.println();
        }
    }

    private static void findWinner(CarRacing carRacing) {
        OutputView.printWinners(carRacing.getWinners());
    }
}
