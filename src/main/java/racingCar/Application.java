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
        playEachRoundAndOutputIncludingTitleAndWinners(roundNum);
    }

    private static void playEachRoundAndOutputIncludingTitleAndWinners(int roundNum) {
        OutputView.printResultTitle();
        playEachRoundAndOutput(roundNum);
        OutputView.printWinners(RacingCar.players);
    }

    private static void playEachRoundAndOutput(int roundNum) {
        for (int round = 0; round < roundNum; round++) {
            OutputView.printRoundResultWithRoundNum(round, RacingCar.players);
            RacingCar.playWithRandoms();
        }
        OutputView.printRoundResultWithRoundNum(roundNum, RacingCar.players);
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