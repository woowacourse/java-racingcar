package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AttemptNumberTest {

    @DisplayName("시도 횟수가 양의 정수가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @CsvSource({"-1", "0"})
    void should_ThrowIllegalArgumentException_When_AttemptNumberIsNotPositiveInteger(int attemptNumber) {
        assertThatThrownBy(() -> new AttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("시도 횟수가 양의 정수라면 예외를 던지지 않는다.")
    @ParameterizedTest
    @CsvSource({"1, 100"})
    void should_DoesNotThrowException_When_AttemptNumberIsPositiveInteger(int attemptNumber) {
        assertThatCode(() -> new AttemptNumber(attemptNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수가 100 초과의 양의 정수라면 예외를 던진다.")
    @ParameterizedTest
    @CsvSource({"101", "10000"})
    void should_ThrowIllegalArgumentException_When_AttemptNumberIsInvalid(int attemptNumber) {
        assertThatThrownBy(() -> new AttemptNumber(attemptNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("decrease 메서드는 attemptNumber 의 값을 1 감소시킨다.")
    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "3,2"})
    void should_DecreaseByOne_When_UsingDecreaseMethod(int beforeValue, int afterValue) {
        //given
        AttemptNumber attemptNumber = new AttemptNumber(beforeValue);

        //when
        attemptNumber.decrease();

        //then
        assertThat(attemptNumber.getAttemptNumber()).isEqualTo(afterValue);
    }

    @DisplayName("isRemain 메서드는 attemptNumber 값이 남아있는지 확인한다.")
    @ParameterizedTest
    @CsvSource({"1,false", "2,true"})
    void should_DecreaseByOne_When_UsingDecreaseMethod(int beforeDecrease, boolean isRemain) {
        //given
        AttemptNumber attemptNumber = new AttemptNumber(beforeDecrease);

        //when
        attemptNumber.decrease();

        //then
        assertThat(attemptNumber.isRemain()).isEqualTo(isRemain);
    }
}
