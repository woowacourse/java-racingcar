package model;

public class Round {

    private static final String ROUND_INPUT_ERROR_MESSAGE = "라운드 입력이 잘못되었습니다.";
    private static final int MIN_ROUND_NUMBER = 0;
    private int round;

    public Round(int round) {
        validateRound(round);
        this.round = round;
    }

    static void validateRound(int round) {
        if (round <= MIN_ROUND_NUMBER) {
            throw new IllegalArgumentException(ROUND_INPUT_ERROR_MESSAGE);
        }
    }

    public boolean isLastRound() {
        return this.round == MIN_ROUND_NUMBER;
    }

    public void afterOneRound() {
        this.round--;
    }

}
