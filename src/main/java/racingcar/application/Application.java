package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private static final int ERROR_THRESHOLD = 5;
    private static final int CONTINUOUS_ERROR_CODE = 0;

    private static int errorCount = 0;

    public static void main(String[] args) {
        CarRacing carRacing = generateCarRacing2();
        int moveNumber = enterValidNumber();

        run(carRacing, moveNumber);
        findWinner(carRacing);
    }

    private static CarRacing generateCarRacing2() {
        while (true) {
            try {
                return new CarRacing(InputView.getNames());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static CarRacing generateCarRacing() {
        try {
            return new CarRacing(InputView.getNames());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            exitProgramByContinuousError();
            return generateCarRacing();
        }
    }

    private static void exitProgramByContinuousError() {
        if (errorCount > ERROR_THRESHOLD) {
            System.out.println("오류 횟수 " + ERROR_THRESHOLD + "회 초과로 프로그램을 종료합니다");
            System.exit(CONTINUOUS_ERROR_CODE);
        }
        errorCount++;
    }

    private static int enterValidNumber() {
        int output = 0;
        boolean isInputNeeded = true;

        while(isInputNeeded) {
            output = InputView.getMoveNumber();
            if (output > 0) {
                isInputNeeded = false;
            }
        }
        return output;
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
