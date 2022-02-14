package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.numbergenerator.MovableNumberGenerator;

public class CarsTest {

    @Test
    void 자동차_2개_미만() {
        assertThatThrownBy(() -> new Cars(List.of("rick"), new MovableNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @Test
    void 자동차_5개_초과() {
        assertThatThrownBy(
                () -> new Cars(List.of("rick", "huni", "sudal", "ukong", "tomy", "pobi"),
                        new MovableNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.");
    }
}