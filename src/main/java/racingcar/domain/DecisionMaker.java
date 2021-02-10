package racingcar.domain;

/**
 * DecisionMaker.java
 * 자동차의 전진 여부 판단을 위임받는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class DecisionMaker {
    public static final int BASIC_THRESHOLD = 4;

    private final int threshold;

    public DecisionMaker() {
        this.threshold = BASIC_THRESHOLD;
    }

    public boolean makeDecisionByNumber(int number) {
        return number >= threshold;
    }
}
