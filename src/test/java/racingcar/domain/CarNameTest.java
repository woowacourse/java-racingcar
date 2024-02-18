package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarName;

class CarNameTest {


    @DisplayName("공백 제외 5글자 이하 생성")
    @ParameterizedTest
    @ValueSource(strings = {" hhhhh ", "abcd ", "  abcde", "정상길이", "이름"})
    void invalidLength(String name) {
        CarName carName = new CarName(name);

        assertThat(carName.getName()).isEqualTo(name.trim());
    }

    @DisplayName("자동차 이름 길이가 5 초과시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", "1234567890"})
    void invalidNameSize(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름의 길이는 5이하만 가능 합니다.");
    }

    @DisplayName("자동차 이름이 빈값일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @NullSource
    void blankName(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 빈 값일 수 없습니다.");
    }
}
