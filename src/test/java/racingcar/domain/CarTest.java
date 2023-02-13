package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    private Car car;

    @BeforeEach
    void car_객체_생성() {
        car = new Car("judy");
    }

    @Test
    void status_초기값_확인() {
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void status_증가_확인() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carName_확인() {
        assertThat(car.getCarName()).isEqualTo("judy");
    }

    @Test
    void dto_carName_status_확인() {
        CarPositionDto dto = new CarPositionDto(0, "judy");

        assertThat(dto.getStatus()).isEqualTo(0);
        assertThat(dto.getCarName()).isEqualTo("judy");
    }
}
