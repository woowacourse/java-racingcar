package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "a", "0", "!"})
    @DisplayName("Round가 생성될 때 시도 횟수가 숫자가 아니고 1보다 작은 값이 입력되면 에러를 발생시킨다.")
    void roundGenerateTest(String input) {
        //When + Then
        assertThatThrownBy(() -> new Round(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
