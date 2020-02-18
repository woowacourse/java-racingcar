package racinggame.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {
    @ParameterizedTest
    @ValueSource(strings = {"10", "5", "0"})
    void 위치값_생성_테스트(int value) {
        Position position = new Position(value);
        Assertions.assertThat(position.match(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-214"})
    void 위치값_오류_테스트(int value) {
        Assertions.assertThatThrownBy(() -> {
            Position position = new Position(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("위치값은 0 이상이어야 합니다.");
    }

    @Test
    void 위치값_가속메서드_호출_테스트() {
        Position position1 = new Position(0);
        position1.accelerate();

        Assertions.assertThat(position1.match(1)).isTrue();

        Position position2 = new Position(0);
        position2.accelerate(3);

        Assertions.assertThat(position2.match(3)).isTrue();
    }

    @Test
    void 위치값_가속메서드_에러_테스트() {
        Position position1 = new Position(0);

        Assertions.assertThatThrownBy(() -> position1.accelerate(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("잘못된 요청이 가속 메서드에 전달되었습니다");

        Position position2 = new Position(100000);
        Assertions.assertThatThrownBy(() -> position2.accelerate(2147483647))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("잘못된 요청이 가속 메서드에 전달되었습니다");
    }
}
