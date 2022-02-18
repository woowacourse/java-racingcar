package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.ExceptionMessage;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    @Test
    @DisplayName("자동차 이름의 길이가 5 초과일 경우 예외를 발생 시킨다.")
    void create_LongerLengthOfCarNameThanFive() {
        String longerThanFiveCarName = "abcdef";
        assertThatThrownBy(() -> new CarName(longerThanFiveCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LONGER_THAN_FIVE_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름이 공백으로만 이루어진 경우 예외를 발생시킨다.")
    void create_BlankCarName() {
        String blankCarName = " ";
         assertThatThrownBy(() -> new CarName(blankCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.BLANK_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름이 null일 경우 예외를 발생시킨다.")
    void create_NullCarName() {
        String nullCarName = null;
         assertThatThrownBy(() -> new CarName(nullCarName))
                        .isInstanceOf(NullPointerException.class)
                        .hasMessage(ExceptionMessage.NULL_CAR_NAME);
    }
}
