package racingcar.controller;

import racingcar.view.RacingCarError;
import racingcar.view.RacingCarView;

public class TurnsGenerator {

    private static final int ZERO_VALUE = 0;

    public static int generateTurn(String candidateNumber) {
        checkTurns(candidateNumber);
        return Integer.parseInt(candidateNumber);
    }

    public static void checkTurns(String turnCandidate) {
        int integerCandidate = checkInteger(turnCandidate);
        checkNegative(integerCandidate);
    }

    private static int checkInteger(String turnCandidate) {
        try {
            return Integer.parseInt(turnCandidate);
        } catch (Exception error) {
            RacingCarError.notInteger();
            return ZERO_VALUE;
        }
    }

    private static void checkNegative(int integerCandidate) {
        if (integerCandidate < ZERO_VALUE) {
            RacingCarError.negativeInteger();
        }
    }
}
