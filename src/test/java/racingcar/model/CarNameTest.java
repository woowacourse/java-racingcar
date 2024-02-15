package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {


    @DisplayName("공백 제외 5글자 이하 생성")
    @ParameterizedTest
    @ValueSource(strings = {" hhhhh ", "abcd ", "  abcde"})
    void invalidLength(String name) {
        // given
        // when
        CarName carName = new CarName(name);

        // then
        Assertions.assertThat(carName.getName()).isEqualTo(name.trim());
    }

    @DisplayName("자동차 이름 길이가 5 초과시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", "1234567890"})
    void invalidNameSize(String name) {
        Assertions.assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 자동차 이름 등록 확인")
    @ParameterizedTest
    @ValueSource(strings = {"정상길이", "이름"})
    void createCar(String name) {
        CarName carName = new CarName(name);
        Assertions.assertThat(carName.getName()).isEqualTo(name);
    }
}