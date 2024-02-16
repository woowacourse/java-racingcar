package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 파워 전략 테스트")
public class PowerStrategyTest {

    @Test
    @DisplayName("자동차는 랜덤 숫자에 따라 움직이거나 움직일 수 없다.")
    void canMoveByRandomNumber() { // TODO: can test random value?
        assertThat(PowerStrategy.from().canMove()).isTrue();
    }
}
