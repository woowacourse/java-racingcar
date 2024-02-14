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
}