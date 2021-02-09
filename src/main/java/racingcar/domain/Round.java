package racingcar.domain;

public class Round {
    private static final String ROUND_MUST_POSITIVE_ERROR_MSG_FORMAT = "[ERROR] 라운드 수는 음수일 수 없습니다. 입력받은 라운드 수 : %d";
    private static final int ONE = 1;

    private final int round;

    public Round(int round) {
        validateTargetRound(round);
        this.round = round;
    }

    public boolean isBiggerThan(Round that){
        return this.round > that.round;
    }

    public int getRound(){
        return round;
    }

    private void validateTargetRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException(String.format(ROUND_MUST_POSITIVE_ERROR_MSG_FORMAT, round));
        }
    }

    public Round nextRound() {
        return new Round(round + ONE);
    }
}
