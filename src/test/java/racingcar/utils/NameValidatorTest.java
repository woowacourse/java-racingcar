package racingcar.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameValidatorTest {
    @Test
    void 자동차이름_빈_문자() {
        assertThatThrownBy(() -> NameValidator.isValidateName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_공백() {
        assertThatThrownBy(() -> NameValidator.isValidateName("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_5글자초과() {
        assertThatThrownBy(() -> NameValidator.isValidateName("donghok"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_중복() {
        assertThatThrownBy(() -> NameValidator.isDuplicatedNames(Arrays.asList("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
