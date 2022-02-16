package racingcar.domain.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MovementUtilTest {

    @ParameterizedTest(name = "isMoveForward 전진 실패 테스트 : {0}")
    @ValueSource(ints = {1, 3})
    public void isMoveForward_stop_test(int input) throws Exception {
        assertThat(MovementUtil.isMoveForward(input)).isFalse();
    }

    @ParameterizedTest(name = "isMoveForward 전진 성공 테스트 : {0}")
    @ValueSource(ints = {4, 7, 9})
    public void isMoveForward_move_test(int input) throws Exception {
        assertThat(MovementUtil.isMoveForward(input)).isTrue();
    }
}
