package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidCarNameException;
import racingcar.exception.InvalidNumOfMoveException;


class ValidateUtilsTest {

    @Test
    public void 자동차_갯수_2개_이상_테스트_negative() {
        // given, when
        String[] carNames = {"pobi"};

        // then
        assertThatThrownBy(() -> ValidateUtils.validateCarNames(carNames))
            .isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    public void 자동차_이름_5자_이상_테스트_negative() {
        // given, when
        String[] carNames = {"pobi", "hong", "gil", "mark", "honggildong"};

        // then
        assertThatThrownBy(() -> ValidateUtils.validateCarNames(carNames))
            .isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    public void 자동차_이름_공백_테스트_negative() {
        // given, when
        String[] carNames = {"pobi", "hong", "gil", ""};

        // then
        assertThatThrownBy(() -> ValidateUtils.validateCarNames(carNames))
            .isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    public void 자동차_이름_null_테스트_negative() {
        // given, when
        String[] carNames = {"pobi", "hong", "gil", null};

        // then
        assertThatThrownBy(() -> ValidateUtils.validateCarNames(carNames))
            .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2", "d"})
    @NullAndEmptySource
    public void 시도횟수_음수_및_숫자아닌_입력값_테스트_negative(String invalidInput) {
        assertThatThrownBy(() -> ValidateUtils.validateRacingRoundCount(invalidInput))
            .isInstanceOf(InvalidNumOfMoveException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    public void 시도횟수_positive(String input, int expected) {
        assertThat(ValidateUtils.validateRacingRoundCount(input))
            .isEqualTo(expected);
    }
}