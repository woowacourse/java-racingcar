package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("불변 객체 테스트")
    public void check_construct() {
        assertThat(new Name("park")).isEqualTo(new Name("park"));
    }

    @Test
    @DisplayName("자동차 이름이 5자보다 길경우 예외가 발생하는지 테스")
    public void check_car_name_exception() {
        assertThatThrownBy(() -> new Name("super car"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[Error] 자동차 이름은 5자이하여야 합니다.");
    }

}
