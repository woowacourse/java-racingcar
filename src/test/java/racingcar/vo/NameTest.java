package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.vo.Name;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "aaaaaa", ""})
    @DisplayName("Name 생성시 에러 발생 테스트")
    void nameFailTest(String carName) {
        assertThatThrownBy(() -> new Name(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"gavi", "jude", "pobi"})
    @DisplayName("Name 생성 성공 테스트")
    void carNameSuccessTest(String carName) {
        new Name(carName);
    }

}