package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 객체_생성() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void null_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }

    @Test
    void 길이가_0인_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void 공백_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("  ");
        });
    }

    @Test
    void 다섯_글자_이상_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("ppoobbii");
        });
    }

    @Test
    void 정지() {
        Car car = new Car("pobi", 0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 전진() {
        Car car = new Car("pobi", 0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 더_먼_위치() {
        Car car = new Car("pobi", 4);
        Car anotherCar = new Car("cu", 5);

        assertThat(car.comparePosition(anotherCar)).isEqualTo(1);
    }

    @Test
    void 같은_위치() {
        Car car = new Car("pobi", 5);
        Car anotherCar = new Car("cu", 5);

        assertThat(car.comparePosition(anotherCar)).isEqualTo(0);
    }
}
