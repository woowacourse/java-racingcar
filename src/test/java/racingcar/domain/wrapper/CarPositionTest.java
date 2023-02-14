package racingcar.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.constant.CarConstant.INIT_POSITION;

class CarPositionTest {

    @Test
    @DisplayName("초기 CarPosition 객체 생성 시 position은 1이어야 한다.")
    void givenNormalPosition_thenSuccess() {
        // given, when
        CarPosition carPosition = CarPosition.create();
        int position = carPosition.getPosition();

        // then
        assertThat(carPosition)
                .isIn(CarPosition.class);

        assertThat(position)
                .isEqualTo(INIT_POSITION.getValue());
    }
}