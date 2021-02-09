package racingcar.domain.engine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EngineTest {

    @Test
    public void 자동차_이동_테스트() {
        // given, when
        Engine movableEngine = new FixedEngine(9);
        Engine nonMovableEngine = new FixedEngine(3);

        // then
        assertThat(movableEngine.isMove()).isTrue();
        assertThat(nonMovableEngine.isMove()).isFalse();
    }
}