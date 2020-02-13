package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    Names names = new Names("pobi,elly,rutgo");
    @Test
    void 쉼표_기준으로_입력값_구분() {
        assertThat(names.get(0)).contains("pobi");
        assertThat(names.get(1)).contains("elly");
        assertThat(names.get(2)).contains("rutgo");
    }
}
