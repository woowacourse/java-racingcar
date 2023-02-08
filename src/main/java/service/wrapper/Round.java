package service.wrapper;

import exception.WrongRoundException;

public class Round {

    private static final int MIN_VALUE = 1;

    private final int round;

    public Round(String inputRound) {
        int round = mapToRound(inputRound);

        validateRound(round);
        this.round = round;
    }

    private int mapToRound(String inputRound) {
        try {
            return Integer.parseInt(inputRound);
        } catch (NumberFormatException e) {
            throw new WrongRoundException();
        }
    }

    private void validateRound(int round) {
        if (round < MIN_VALUE) {
            throw new WrongRoundException();
        }
    }

    public int getRound() {
        return round;
    }
}
