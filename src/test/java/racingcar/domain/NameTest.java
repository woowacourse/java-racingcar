package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"park", "kim", "han"})
    @DisplayName("불변 객체 테스트")
    public void check_construct(String name) {
        assertThat(new Name(name)).isEqualTo(new Name(name));
    }

    @Test
    @DisplayName("자동차 이름이 5자보다 길경우 예외가 발생하는지 테스트")
    public void check_car_name_exception() {
        assertThatThrownBy(() -> new Name("super car"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[Error] 자동차 이름은 5자이하여야 합니다.");
    }

}