package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    void checkCarNames() {
        assertThatThrownBy(() ->
            CarNameValidator.checkCarNames(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백일 수 없습니다.");
    }

    @Test
    void checkQuantity() {
        assertThatThrownBy(() ->
            CarNameValidator.checkQuantity(new String[]{}))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1대 이상");
    }

    @Test
    void checkCarName_null() {
        assertThatThrownBy(() ->
            CarNameValidator.checkCarName(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은");
    }

    @Test
    void checkCarName_empty() {
        assertThatThrownBy(() ->
            CarNameValidator.checkCarName(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은");
    }

    @Test
    void checkCarName_exceeds_5() {
        assertThatThrownBy(() ->
            CarNameValidator.checkCarName("longName"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은");
    }
}