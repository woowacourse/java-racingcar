package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @DisplayName("자동차 이름 공백 테스트")
    @Test
    void car_name_empty() {
        assertThatThrownBy(() -> {
            Validator.carName(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 null 테스트")
    @Test
    void car_name_null() {
        assertThatThrownBy(() -> {
            Validator.carName(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("자동차 개수 테스트")
    @Test
    void car_count_test() {
        assertThatThrownBy(() -> {
            Validator.carName("pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 중복 테스트")
    @Test
    void car_name_duplicated() {
        assertThatThrownBy(() -> {
            Validator.carName("pobi,jun,pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 길이 테스트")
    @Test
    void car_name_length() {
        assertThatThrownBy(() -> {
            Validator.carName("gooddd");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}