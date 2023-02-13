package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdvanceJudgementTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    @DisplayName("range범위의 수를 넣었을 때 전진이 가능한지 테스트")
    public void 전진_가능_경우_테스트(int num) {
        Range range = new Range(4, 9);
        NumberGenerator numberGenerator = new DefaultNumberGenerator(num);
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(range, numberGenerator);

        assertTrue(advanceJudgement.isAdvancePossible());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10, -1})
    @DisplayName("range범위가 아닌 수를 넣었을 때 전진하지 않는지 테스트")
    public void 전진_불가능_경우_테스트(int num) {
        Range range = new Range(4, 9);
        NumberGenerator numberGenerator = new DefaultNumberGenerator(num);
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(range, numberGenerator);

        assertFalse(advanceJudgement.isAdvancePossible());
    }
}