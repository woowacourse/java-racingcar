package carracinggame.controller;

import carracinggame.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    CarRacing carRacing = new CarRacing();
    @DisplayName("자동차 이름 정상 입력")
    @Test
    void 자동차_이름_정상_입력() {
        String[] carNames = carRacing.createCarNames("a,b,c");
        assertThat(carNames).isEqualTo(new String[]{"a", "b", "c"});
    }
}
