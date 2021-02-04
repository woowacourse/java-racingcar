package racingCar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class ValidateUtilsTest {

    // 자동차 이름 -> 1자 이하 5자 이상, 공백

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
    public void 자동차_이름_5자_이하_테스트_positive() {
        // given, when
        String[] carNames = {"pobi", "hong", "gil", "mark"};

        // then

    }

    @Test
    public void 자동차_이름_공백_테스트_negative() {
        // given, when
        String[] carNames = {"pobi","hong","gil","",null};

        // then
        assertThrows(RuntimeException.class, ()->{
            ValidateUtils.validateCarNames(carNames);
        });
    }

    @Test
    public void 시도횟수_음수_negative() {
        // given, when
        String count = "-2";

        // then
        assertThrows(RuntimeException.class, ()->{
            ValidateUtils.validateRacingRoundCount(count);
        });
    }

    @Test
    public void 시도횟수_숫자아님_negative() {
        // give, when
        String count = "d";

        // then
        assertThrows(RuntimeException.class, ()->{
            ValidateUtils.validateRacingRoundCount(count);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1","2:2","3:3","4:4","5:5"},delimiter = ':')
    public void 시도횟수_성공케이스(String input, String expected) {
        assertThat(ValidateUtils.validateRacingRoundCount(input)).isEqualTo(Integer.parseInt(expected));
    }

}