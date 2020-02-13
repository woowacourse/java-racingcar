package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NamesTest {
    private Names names;

    @Test
    void 쉼표_기준으로_입력값_구분() {
        names = new Names("pobi,elly,rutgo");
        List<Name> namesList = names.getNames();
        assertThat(namesList.get(0).toString()).contains("pobi");
        assertThat(namesList.get(0).toString()).contains("elly");
        assertThat(namesList.get(0).toString()).contains("rutgo");
    }

    @Test
    void 입력값으로_쉼표만_들어왔을_때_예외처리_테스트() {
        assertThatThrownBy(() -> new Names(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력해주세요.");
    }
}
