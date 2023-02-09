package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingStatusDto;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {
    private Car car;

    @BeforeEach
    void car_객체_생성() {
        car = new Car("judy");
    }

    @Test
    void status_초기값_확인() {
        assertThat(car.getStatus()).isEqualTo(0);
    }

    @Test
    void status_증가_확인() {
        car.move();
        assertThat(car.getStatus()).isEqualTo(1);
    }

    @Test
    void carName_확인() {
        assertThat(car.getCarName()).isEqualTo("judy");
    }

    @Test
    void dto_carName_status_확인() {
        RacingStatusDto dto = new RacingStatusDto(0, "judy");

        assertThat(dto.getStatus()).isEqualTo(0);
        assertThat(dto.getCarName()).isEqualTo("judy");
    }
}
