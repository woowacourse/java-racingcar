package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.NumberGenerator.NumberGenerator;
import racingcar.domain.NumberGenerator.TestNumberGenerator;

class AdvanceJudgementTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    @DisplayName("범위안의 수를 넣었을 때 전진이 가능한지 테스트")
    public void 전진_가능_경우_테스트(int num) {
        NumberGenerator numberGenerator = new TestNumberGenerator(num);
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(numberGenerator);
        assertThat(advanceJudgement.isAdvancePossible()).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10, -1})
    @DisplayName("범위를 벗어나는 수를 넣었을 때 전진이 불가능한지 테스트")
    public void 전진_불가능_경우_테스트(int num) {
        NumberGenerator numberGenerator = new TestNumberGenerator(num);
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(numberGenerator);
        assertThat(advanceJudgement.isAdvancePossible()).isEqualTo(false);
    }
}