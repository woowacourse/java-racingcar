package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 이름 길이 테스트")
public class CarNameTest {
    @DisplayName("5글자를 초과하는 자동차 이름 테스트")
    @ParameterizedTest
    @CsvSource(value = {"abcdef"})
    void checkNameLength(String value) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(value);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("빈 문자열 자동차 이름 테스트")
    @ParameterizedTest
    @EmptySource
    void checkNameLength_empty(String value) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(value);
        }).isInstanceOf(RuntimeException.class);
    }
}
