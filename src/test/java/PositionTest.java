import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.car.Position;

public class PositionTest {

    @ParameterizedTest
    @ValueSource(strings = {"10", "5", "0"})
    void 위치값_생성_테스트(int value) {
        Position position = new Position(value);
        Assertions.assertThat(position.match(value)).isTrue();
    }
}
