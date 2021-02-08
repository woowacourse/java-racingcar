package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AttemptNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("양의 정수가 아닐 때 AttemptNumber 객체 생성 시 에러 발생하는지 테스트")
    void attemptsNumberErrorTest(int number) {
        // 에러가 잘 출력되는지 테스트
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new AttemptNumber(number);
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 8, 10})
    @DisplayName("양의 정수일 때 AttemptNumber 객체 생성되는지 테스트")
    void attemptsNumberTest(int number) {
        // 에러가 출력이 안되고 잘 동작하는지 테스트
        AttemptNumber attemptNumber = new AttemptNumber(number);
        assertThat(attemptNumber.getAttemptNumber()).isEqualTo(number);
    }
}
