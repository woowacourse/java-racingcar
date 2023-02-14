package racingcar.domain.wrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.constant.CarConstant.INIT_POSITION;

class CarPositionTest {

    private CarPosition carPosition;

    @BeforeEach
    void init() {
        carPosition = CarPosition.create();
    }

    @Test
    @DisplayName("초기 CarPosition 객체 생성 시 position은 1이어야 한다.")
    void givenNormalPosition_thenSuccess() {
        // given, when
        int position = carPosition.getPosition();

        // then
        assertThat(carPosition)
                .isInstanceOf(CarPosition.class);

        assertThat(position)
                .isEqualTo(INIT_POSITION.getValue());
    }

    @Test
    @DisplayName("위치 값을 1 증가시킨다.")
    void whenAddPosition_thenPositionPlus() {
        // given
        int beforePosition = carPosition.getPosition();

        // when
        carPosition.addPosition();

        // then
        assertThat(carPosition.getPosition())
                .isEqualTo(beforePosition + 1);
    }
}