package racing.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @DisplayName("보장된 위치 값, 정상 생성된다.")
    @Test
    void positionSaveTest() {
        int position = 3;
        assertThatCode(() -> Position.of(position))
                .doesNotThrowAnyException();
    }

    @DisplayName("보장된 위치 값이 아니면 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void positionSaveErrorTest(int position) {
        assertThatThrownBy(() -> Position.of(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("위치 값은 0 이상이어야 합니다."));
    }

    @DisplayName("Position의 값 정상 증가 된다.")
    @Test
    void positionAddTest() {
        //given
        int value = 0;
        Position position = Position.of(value);

        //when
        position.add();

        //then
        assertThat(position.getValue()).isEqualTo(1);
    }
}
