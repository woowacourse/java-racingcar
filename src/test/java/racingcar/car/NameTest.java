package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Name;

public class NameTest {

    @Test
    @DisplayName("정상적인 자동차 이름 입력")
    void generateNameTest_정상_입력() {
        assertThatCode(() -> {
            new Name("루트");
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("기능 요구사항보다 너무 길거나 짧은 자동차 이름 입력")
    @ValueSource(strings = {"너무 긴 이름", ""})
    void generateNameTest_잘못된_길이_입력(String name) {
        assertThatThrownBy(() -> {
            new Name(name);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자 이하로 입력해주세요.");
    }
}
