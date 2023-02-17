package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carName_확인() {
        assertThat(car.getCarName()).isEqualTo("judy");
    }
}
