package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineTest {

    @Test
    void 엔진_랜덤_생성_테스트() {
        Engine engine = Engine.getRandom();
        assertThat(engine.getPower()).isBetween(0, 9);
    }
}
