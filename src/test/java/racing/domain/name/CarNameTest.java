package racing.domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @DisplayName("보증된 자동차 이름 정상 생성된다")
    @Test
    void carNameSaveTest() {
        assertThatCode(() -> new CarName("pobi"))
                .doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 자동차 이름으로 객체 생성시 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "ab..bb", "  ", ""})
    void carNameSaveErrorTest(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 유효하지 않은 이름입니다. 영어 대소문자만 입력해주세요.", name));
    }
}