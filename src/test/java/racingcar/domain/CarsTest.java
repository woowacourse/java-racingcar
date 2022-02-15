package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.movestrategy.MovableMovingStrategy;

public class CarsTest {

    @Test
    void 자동차_2개_미만() {
        assertThatThrownBy(() -> new Cars(List.of("rick"), new MovableMovingStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @Test
    void 자동차_5개_초과() {
        assertThatThrownBy(
                () -> new Cars(List.of("rick", "huni", "sudal", "ukong", "tomy", "pobi"),
                        new MovableMovingStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상 5대 이하이어야 합니다.");
    }
}