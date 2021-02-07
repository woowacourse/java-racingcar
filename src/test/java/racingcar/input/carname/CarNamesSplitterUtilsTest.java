package racingcar.input.carname;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNamesSplitterUtilsTest {

    @DisplayName("자동차 이름이 쉼표(,)를 기준으로 구분되는가?")
    @Test
    void splitCarNames() {
        String carNamesInput = "aaa,bbb,ccc";
        List<String> splitCarNames = CarNamesSplitterUtils.splitCarNames(carNamesInput);
        assertThat(splitCarNames.get(0)).isEqualTo("aaa");
        assertThat(splitCarNames.get(1)).isEqualTo("bbb");
        assertThat(splitCarNames.get(2)).isEqualTo("ccc");
    }
}
