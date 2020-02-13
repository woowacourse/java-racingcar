package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    Names names = new Names("pobi,elly,rutgo");

    @Test
    void 쉼표_기준으로_입력값_구분() {
        List<Name> namesList = names.getNames();
        assertThat(namesList.get(0).toString()).contains("pobi");
        assertThat(namesList.get(0).toString()).contains("elly");
        assertThat(namesList.get(0).toString()).contains("rutgo");
    }
}
