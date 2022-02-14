package racingcar.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class InputControllerTest {
    final InputController inputController = new InputController();

    @Test
    public void 자동차_이름_나누기() {
        String cars = "pobi,crong,honux";
        assertThat(inputController.getUserCarNames(cars)).contains("pobi", "crong", "honux");
    }

    @Test
    public void 숫자_입력() {
        String scanNumber = "3";
        int actual = inputController.getUserTryCount(scanNumber);
        assertThat(Integer.parseInt(scanNumber)).isEqualTo(actual);
    }
}
