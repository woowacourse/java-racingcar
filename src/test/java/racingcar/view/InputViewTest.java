package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    void 쉼표_기준으로_입력값_구분() {
        String[] carNames = InputView.splitName("pobi,elly,rutgo");
        assertThat(carNames).contains("pobi");
        assertThat(carNames).contains("elly");
        assertThat(carNames).contains("rutgo");
    }
}