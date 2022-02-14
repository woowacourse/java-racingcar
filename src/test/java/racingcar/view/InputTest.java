package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputTest {

    static Input input = new Input();

    @DisplayName("자동차 이름 공백 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void car_name_empty(String name) {
        assertThatThrownBy(() -> {
            input.checkBlank(name, "자동차 이름은 공백일 수 없습니다.");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 null 테스트")
    @Test
    void car_name_null() {
        assertThatThrownBy(() -> {
            input.checkBlank(null, "자동차 이름은 null 일 수 없습니다.");
        }).isInstanceOf(NullPointerException.class);
    }
    
    @DisplayName("자동차 개수 테스트")
    @Test
    void car_count_test() {
        assertFalse(input.isCars(split("pobi")));
    }

    @DisplayName("자동차 이름 중복 테스트")
    @Test
    void car_name_duplicated() {
        assertTrue(input.isDuplicated(split("pobi,jun,pobi")));
    }

    @DisplayName("자동차 이름 길이 테스트")
    @Test
    void car_name_length() {
        assertThatThrownBy(() -> {
            input.validLength("gooddd");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수 공백 테스트")
    @Test
    void attempt_empty() {
        assertThatThrownBy(() -> {
            Validator.attempt(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수 null 테스트")
    @Test
    void attempt_null() {
        assertThatThrownBy(() -> {
            Validator.attempt(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("시도횟수 문자 예외 테스트")
    @Test
    void attempt_number() {
        assertThatThrownBy(() -> {
            Validator.attempt("횟수");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수 음수 테스트")
    @Test
    void attempt_negative() {
        assertThatThrownBy(() -> {
            Validator.attempt("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    String[] split(String text) {
        return text.split(",");
    }
}