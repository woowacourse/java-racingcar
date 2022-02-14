package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameValidatorTest {
    @Test
    void 빈_문자_입력() {
        assertThatThrownBy(() -> NameValidator.isValidateNames(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_1글자미만() {
        assertThatThrownBy(() -> NameValidator.isValidateNames("pobi,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_5글자초과() {
        assertThatThrownBy(() -> NameValidator.isValidateNames("pobi,donghok"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_1개() {
        Assertions.assertThatCode(() -> NameValidator.isValidateNames("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차이름_중복() {
        assertThatThrownBy(() -> NameValidator.isDuplicatedNames(Arrays.asList("pobi","pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
