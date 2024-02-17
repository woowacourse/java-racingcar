package domain;

import static constant.Numbers.MAX_ROUND;
import static constant.Numbers.MIN_ROUND;

public class Round {

    private final int round;

    public Round(String rawRound) {
        this.round = makeRoundFrom(rawRound);
    }

    public int getRound() {
        return round;
    }

    private int makeRoundFrom(String rawRound) {
        try {
            int round = Integer.parseInt(rawRound);
            validate(round);
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validate(int round) {
        if (round < MIN_ROUND || round > MAX_ROUND) {
            throw new IllegalArgumentException(
                "시도 횟수는 " + MIN_ROUND + " ~ " + MAX_ROUND + "만 입력 가능합니다.");
        }
    }
}
