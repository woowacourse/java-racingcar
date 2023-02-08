package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"dazzle", ""})
    @DisplayName("이름의 길이가 없거나 5보다 크다면 예외를 던진다.")
    void should_throwException_when_invalidNameLength(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차의 이름은 1자 이상 ~ 5자 이하여야 합니다.");
    }

}
