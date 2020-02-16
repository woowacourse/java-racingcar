package racingCar;

import racingCar.domain.RacingCar;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.InputMismatchException;

public class Application {
    public static void main(String[] args) {
        int roundNum;

        inputUserNameAndInitRacingCar();
        roundNum = inputRoundNumWithHandleException();
        playEachRoundWithOutputRelating(roundNum);
    }

    private static void playEachRoundWithOutputRelating(int roundNum) {
        OutputView.printResultTitle();
        playEachRoundWithOutput(roundNum);
        OutputView.printWinners(RacingCar.getWinners());
    }

    private static void playEachRoundWithOutput(int roundNum) {
        for (int round = 0; round < roundNum; round++) {
            OutputView.printRoundNum(roundNum);
            OutputView.printRoundResult(RacingCar.getPlayerNames(),
                    RacingCar.getPlayerPositions());
            RacingCar.playWithRandoms();
        }
        OutputView.printRoundNum(roundNum);
        OutputView.printRoundResult(RacingCar.getPlayerNames(),
                RacingCar.getPlayerPositions());
    }

    private static int inputRoundNumWithHandleException() {
        try {
            return InputView.InputNumberOfRound();
        } catch (InputMismatchException e) {
            OutputView.printInvalidRoundNumWarning();
            InputView.removeBuffer();
            return inputRoundNumWithHandleException();
        }
    }

    public static void inputUserNameAndInitRacingCar() {
        String userNames = InputView.inputUserNames();
        boolean isReady = RacingCar.init(userNames);
        if (isReady) {
            return;
        }

        OutputView.printInvalidNameWarning();
        inputUserNameAndInitRacingCar();
    }
}