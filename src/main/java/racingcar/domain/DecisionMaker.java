package racingcar.domain;

/**
 * DecisionMaker.java
 * 자동차의 전진 여부 판단을 위임받는 유틸 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class DecisionMaker {
    public static final int THRESHOLD = 4;

    public static boolean makeDecisionByNumber(int number) {
        return number >= THRESHOLD;
    }
}
