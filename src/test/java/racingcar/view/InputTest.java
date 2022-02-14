package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
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
}