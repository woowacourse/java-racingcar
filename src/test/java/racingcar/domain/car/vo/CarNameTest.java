package racingcar.domain.car.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("null 값으로 CarName을 생성하려 하면 예외를 발생시킨다.")
    void create_Null_Test() {
        //given
        String expectedExceptionMessage = "자동차 이름에 null이 들어왔습니다.";
        //when, then
        assertThatThrownBy(() -> CarName.valueOf(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5 초과일 경우 예외를 발생 시킨다.")
    void create_LongerLengthOfCarNameThanFive_Test() {
        //given
        String longerThanFiveCarName = "abcdef";
        String expectedExceptionMessage = "자동차 이름은 최대 5자입니다.";
        //when, then
        assertThatThrownBy(() -> CarName.valueOf(longerThanFiveCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("자동차 이름이 공백으로만 이루어진 경우 예외를 발생시킨다.")
    void create_BlankCarName_Test() {
        //given
        String blankCarName = " ";
        String expectedExceptionMessage = "공백으로만 이루어진 자동차 이름이 있습니다.";
        //when, then
        assertThatThrownBy(() -> CarName.valueOf(blankCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }
}