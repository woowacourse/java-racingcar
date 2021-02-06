package racingCar.domain.Engine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EngineTest {

    @Test
    public void fixed_엔진_테스트() {
        // given, when
        Engine movableEngine = new FixedEngine(9);
        Engine nonMovableEngine = new FixedEngine(3);

        // then
        assertThat(movableEngine.isMove()).isEqualTo(true);
        assertThat(nonMovableEngine.isMove()).isEqualTo(false);
    }

}