package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DecisionMakerTest {
    DecisionMaker decisionMaker = new DecisionMaker();

    @DisplayName("makeRunFlagByNumber(int) -> Threshold 값 이하의 인자를 받는 경우 false 리턴")
    @Test
    public void makeRunFlagFalseTest() {
        int lessThanThreshold = DecisionMaker.BASIC_THRESHOLD - 1;
        assertFalse(decisionMaker.makeDecisionByNumber(lessThanThreshold));
    }

    @DisplayName("makeRunFlagByNumber(int) -> Threshold 값 이상의 인자를 받는 경우 true 리턴")
    @Test
    public void makeRunFlagTrueTest() {
        int overThanThreshold = DecisionMaker.BASIC_THRESHOLD;
        assertThat(decisionMaker.makeDecisionByNumber(overThanThreshold)).isTrue();
    }
}