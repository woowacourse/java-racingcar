package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TrialCountTest {

    @DisplayName("시도 횟수가 0 이하인 경우, 예외를 발생시킨다")
    @ParameterizedTest
    @CsvSource({"0", "-1"})
    void creationFailTest(int amount) {
        Assertions.assertThatThrownBy(() -> new TrialCount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 1 이상인 경우, 정상적으로 객체를 생성한다")
    @ParameterizedTest
    @CsvSource({"1", "2"})
    void creationSuccessTest(int amount) {
        Assertions.assertThatCode(() -> new TrialCount(amount))
                .doesNotThrowAnyException();
    }

    @DisplayName("특정 횟수 만큼 반복 동작한다.")
    @Test
    void repeatTest() {
        int expected = 4;
        TrialCount trialCount = new TrialCount(expected);
        Count count = new Count();

        trialCount.repeat(count::addCount);

        Assertions.assertThat(count.getAmount()).isEqualTo(expected);
    }

    static class Count {
        private int amount;

        public void addCount() {
            amount++;
        }

        public int getAmount() {
            return amount;
        }
    }
}