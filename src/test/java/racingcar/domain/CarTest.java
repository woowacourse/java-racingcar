package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("1회 이동")
    void shouldPlusOneAtMovedCountWhenMove() {
        // given
        Car targetCar = new Car("test");
        CarDto carDtoBeforeMove = targetCar.getStatus();
        // when
        targetCar.move();
        CarDto carDtoAfterMove = targetCar.getStatus();
        // then
        assertThat(carDtoAfterMove.getName()).isEqualTo(carDtoBeforeMove.getName()).as("이름이 같아야 한다.");
        assertThat(carDtoAfterMove.getMovedCount()).isEqualTo(carDtoBeforeMove.getMovedCount() + 1).as("이동 횟수는 1이 더해진다.");
    }
}