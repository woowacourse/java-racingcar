package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NameTest {
    @DisplayName("from 메소드에 정상적인 문자열을 전달하면, 정상적으로 객체가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde", "hudi", "tonic", "a", "토닉", "후디", "123"})
    void from(String input) {
        assertThat(Name.from(input).toString()).isEqualTo(input);
    }

    @DisplayName("from 메소드에 빈 값이 주어지면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void fromWithEmptyString(String input) {
        assertThatThrownBy(() -> Name.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("from 메소드에 한글자 미만 혹은 다섯글자 초과의 문자열을 전달하면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void fromWithInvalidStringLength(String input) {
        assertThatThrownBy(() -> Name.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("from 메소드에 허용되지 않는 문자열이 입력되면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "ton*&", "?a1"})
    void fromWithInvalidCharacter(String input) {
        assertThatThrownBy(() -> Name.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
