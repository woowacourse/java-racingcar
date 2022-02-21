package racingcar.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    void 플레이어_이름_5자_초과_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation("aaaaaaa,bbbb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validation.ERROR_NAME_LENGTH);
    }

    @Test
    void 플레이어_이름_0자_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation(",,,bbbb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validation.ERROR_DUPLICATE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"q", "qwerasdfzxcv", "qq23", "aaa", "-5"})
    void 게임_회수_입력_오류검증(String value) {
        assertThatThrownBy(() -> Validation.tryNumValidation(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validation.ERROR_ONLY_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "10", "20"})
    void 게임_회수_입력_참검증(String value) {
        assertThatNoException()
                .isThrownBy(() -> Validation.tryNumValidation(value));
    }

    @Test
    void 플레이어_이름_중복_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation("pobi,crong,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validation.ERROR_DUPLICATE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름_빈값_검증(String value){
        assertThatThrownBy(() -> Validation.carNameValidation(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 게임_빈값_검증(String value){
        assertThatThrownBy(() -> Validation.tryNumValidation(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
