package domain;

import static org.assertj.core.api.Assertions.fail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.ErrorMessages;
import validation.exception.InvalidCountException;
import validation.exception.NotNumberException;

class RaceTest {

    @DisplayName("레이스 시도 횟수 입력이 null인 경우 오류를 던진다.")
    @Test
    void create_fail_null() {
        Assertions.assertThatThrownBy(() -> {
                Race a = new Race(null);
            }).isExactlyInstanceOf(NotNumberException.class)
            .hasMessage(ErrorMessages.NOT_A_NUMBER.getMessage());
    }

    @DisplayName("레이스 시도 횟수 입력이 빈문자열인 경우 오류를 던진다.")
    @Test
    void create_fail_empty() {
        Assertions.assertThatThrownBy(() -> {
                Race a = new Race(null);
            }).isExactlyInstanceOf(NotNumberException.class)
            .hasMessage(ErrorMessages.NOT_A_NUMBER.getMessage());
    }

    @DisplayName("레이스 시도 횟수 입력이 숫자로 이루어지 문자열이 아닌 경우 오류를 던진다.")
    @Test
    void create_fail_not_a_number() {
        Assertions.assertThatThrownBy(() -> {
                Race a = new Race("a");
            }).isExactlyInstanceOf(NotNumberException.class)
            .hasMessage(ErrorMessages.NOT_A_NUMBER.getMessage());
    }

    @DisplayName("레이스 시도 횟수는 1이상이여야 한다.")
    @Test
    void create_fail_zero() {
        Assertions.assertThatThrownBy(() -> {
                Race a = new Race("0");
            }).isExactlyInstanceOf(InvalidCountException.class)
            .hasMessage(ErrorMessages.INVALID_COUNT.getMessage());
    }

    @DisplayName("레이스 시도 횟수는 100,000,000미만 이여야 한다.")
    @Test
    void create_fail_too_big() {
        Assertions.assertThatThrownBy(() -> {
                Race a = new Race("1000000000");
            }).isExactlyInstanceOf(InvalidCountException.class)
            .hasMessage(ErrorMessages.INVALID_COUNT.getMessage());
    }

    @DisplayName("레이스 시도 횟수가 적절한 경우")
    @Test
    void create_success() {
        try {
            Race race = new Race("1");
        } catch (Exception e) {
            fail("정상적으로 Race가 생성되어야 합니다.");
        }
    }
}
