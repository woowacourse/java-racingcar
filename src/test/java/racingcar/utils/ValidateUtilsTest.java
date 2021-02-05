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


class ValidateUtilsTest {

    @DisplayName("경주하는 자동차는 2개 이상이어야 한다")
    @Test
    public void 자동차_갯수_2개_이상_테스트_negative() {
        // given, when
        String[] carNames = {"pobi"};

        // then
        assertThrows(RuntimeException.class, () -> {
            ValidateUtils.validateCarNames(carNames);
        });
    }

    @Test
    public void 자동차_이름_5자_이상_테스트_negative() {
        // given, when
        String[] carNames = {"pobi", "hong", "gil", "mark", "honggildong"};

        // then
        assertThrows(RuntimeException.class, () -> {
            ValidateUtils.validateCarNames(carNames);
        });
    }

    @Test
    public void 자동차_이름_공백_테스트_negative() {
        // given, when
        String[] carNames = {"pobi", "hong", "gil", "", null};

        // then
        assertThrows(RuntimeException.class, () -> {
            ValidateUtils.validateCarNames(carNames);
        });
    }

    @DisplayName("시도횟수는 지정된 조건에 맞는 수가 입력되었습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"-2", "d"})
    @NullAndEmptySource
    void invalidRoundInput(String invalidInput) {
        assertThatThrownBy(() -> {
            ValidateUtils.validateRacingRoundCount(invalidInput);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    public void 시도횟수_성공케이스(String input, String expected) {
        assertThat(ValidateUtils.validateRacingRoundCount(input))
            .isEqualTo(Integer.parseInt(expected));
    }

}