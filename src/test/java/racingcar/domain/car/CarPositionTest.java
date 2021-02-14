package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    @DisplayName("CarPosition 생성 테스트")
    @Test
    void testCreate() {
        //given
        CarPosition carPosition = new CarPosition();

        //when //then
        assertThat(carPosition).isEqualTo(new CarPosition());
    }

    @DisplayName("Move 테스트")
    @Test
    void testMove() {
        //given
        CarPosition carPosition = new CarPosition();

        //when //then
        assertThat(carPosition.move()).isEqualTo(new CarPosition(1));
    }

    @DisplayName("EqualToMaxPosition 메서드테스트")
    @Test
    void testEqualToMaxPosition() {
        //given
        CarPosition carPosition = new CarPosition(4);

        //when //then
        assertThat(carPosition.equalToPosition(4)).isTrue();
    }
}
