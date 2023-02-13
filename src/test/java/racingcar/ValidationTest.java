package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "wugawuga"})
    @DisplayName("자동차 생성 시 이름이 한 글자에서 다섯 글자가 아닐 때 예외")
    void validateName(String name) {
        assertThatThrownBy(() -> Validation.validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 최소 1글자, 최대 5글자까지 가능해요.");
    }


    @Test
    @DisplayName("구분자가 없을 때 예외")
    void validSeparator() {
        String input = "우가.밀리";

        assertThatThrownBy(() -> Validation.validateSeparator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자(,)가 필요해요.");
    }

    @Test
    @DisplayName("경주 참가자가 한명이하일 때 예외")
    void validParticipants() {
        String[] input = {"밀리"};

        assertThatThrownBy(() -> Validation.validateCarCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 경주는 최소 2명이 필요해요.");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 때 예외")
    void validParseInt() {
        assertThatThrownBy(() -> Validation.validateParseInt("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력가능해요");
    }

    @Test
    @DisplayName("시도 횟수가 1 미만일 때 예외")
    void validateTryCount() {
        assertThatThrownBy(() -> Validation.validateTryCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 1미만일 수 없어요.");
    }
}
