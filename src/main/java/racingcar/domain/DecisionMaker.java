package racingcar.domain;

import racingcar.utils.RandomUtils;

/**
 * DecisionMaker.java
 * 자동차의 전진 여부 판단을 위임받는 유틸 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class DecisionMaker {
    private static final int MIN_INCLUSIVE = 0;
    private static final int MAX_INCLUSIVE = 9;
    private static final int THRESHOLD = 4;

    public static boolean makeDecision() {
        int randomNumber = RandomUtils.nextInt(MIN_INCLUSIVE, MAX_INCLUSIVE);
        if (THRESHOLD <= randomNumber) {
            return true;
        }
        return false;
    }
}
