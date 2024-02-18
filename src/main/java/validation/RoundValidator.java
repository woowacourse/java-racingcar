package validation;

import static constant.Numbers.MAX_ROUND;
import static constant.Numbers.MIN_ROUND;

public class RoundValidator {

    public static void validateRound(int round) {
        if (round < MIN_ROUND || round > MAX_ROUND) {
            throw new IllegalArgumentException("1-100로 시도 횟수를 적어주세요.");
        }
    }
}
