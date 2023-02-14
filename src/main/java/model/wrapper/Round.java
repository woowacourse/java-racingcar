package model.wrapper;

import exception.WrongRoundException;

public class Round {

    private static final int ROUND_MIN_VALUE = 1;

    private int round;

    public Round(int round) {
        validateRange(round);
        this.round = round;
    }

    private void validateRange(int inputRound) {
        if (inputRound < ROUND_MIN_VALUE) {
            throw new WrongRoundException();
        }
    }

    public boolean canRacing() {
        return round-- >= ROUND_MIN_VALUE;
    }
}
