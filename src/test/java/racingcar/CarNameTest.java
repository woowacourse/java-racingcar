package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.util.StringUtil;

@SuppressWarnings("NonAsciiCharacters")
public class CarNameTest {

    @Test
    public void 자동차_이름_글자수_테스트() {
        assertThatThrownBy(() -> new CarName("다섯글자이상"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    public void 자동차_이름이_존재하지_않는_경우_테스트() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("모든 자동차 이름은 반드시 존재해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "    "})
    public void 자동차_이름이_공백인_경우_테스트(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 공백으로 설정할 수 없습니다.");
    }
}