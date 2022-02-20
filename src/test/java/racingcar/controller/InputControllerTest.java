package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class InputControllerTest {

    private final InputController inputController = new InputController();

    @DisplayName("자동차 이름 나누기 테스트")
    @Test
    void getUserCarNamesTest() {
        String cars = "pobi,crong,honux";
        assertThat(inputController.getUserCarNames(cars)).contains("pobi", "crong", "honux");
    }

    @DisplayName("숫자 문자열 변환 테스트")
    @Test
    void getUserTryCountTest() {
        String scanNumber = "3";
        int actual = inputController.getUserTryCount(scanNumber);
        assertThat(Integer.parseInt(scanNumber)).isEqualTo(actual);
    }
}
