import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.car.Position;

public class PositionTest {
    Position position;

    @ParameterizedTest
    @ValueSource(strings = {"10", "5", "0"})
    void 위치값_생성_테스트(int value) {
        position = new Position(value);
        Assertions.assertThat(position.match(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-214"})
    void 위치값_오류_테스트(int value) {
        /*
        String 값도 넣어 보려고 했는데, 파라미터가 int형으로 지정되어 있어 NumberFormatException 발생함.
        이는 position이 아닌 position을 호출하는 상위클래스에서 체크해야할듯....
        */
        Assertions.assertThatThrownBy(()->{
            position = new Position(value);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching("위치값은 0 이상이어야 합니다.");
    }

    @Test
    void 위치값_가속메서드_호출_테스트() {
        position = new Position(0);
        position.accelerate();

        Assertions.assertThat(position.match(1)).isTrue();
    }
}
