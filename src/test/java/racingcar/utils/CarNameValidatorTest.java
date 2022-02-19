package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.domain.CarNameValidator.*;

public class CarNameValidatorTest {
    @Test
    @DisplayName("입력한 이름값이 한개인 경우")
    void onlyName() {
        Assertions.assertThatThrownBy(() -> {
                    validateCarNames(new String[]{"pobi"});
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_ONLY_NAME);
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우")
    void longName() {
        Assertions.assertThatThrownBy(() -> {
                    validateCarNames(new String[]{"summer", "crong"});
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_LONG_NAME);
    }

    @Test
    @DisplayName("중복된 이름이 있을 경우")
    void duplicateName() {
        Assertions.assertThatThrownBy(() -> {
                    validateCarNames(new String[]{"pobi", "pobi"});
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_DUPLICATE_NAME);
    }

    @Test
    @DisplayName("빈 이름이 주어지거나 입력값이 없을 경우")
    void emptyName() {
        Assertions.assertThatThrownBy(() -> {
                    validateCarNames(new String[]{""});
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_EMPTY_NAME);
    }

}
