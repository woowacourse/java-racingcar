package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
    @Test
    void 이름의_길이가_기준치에_맞지않으면_예외발생하는지_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("banana");
        });
    }

    @Test
    void 이름이_빈_칸일_경우_예외발생하는지_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("");
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car(" ");
        });
    }

    @Test
    void 자동차가_전진하는지_테스트() {
        Car car = new Car("win");
        car.accelerate(6);

        assertTrue(car.isEqualPosition(1));
    }

    @Test
    void 자동차가_전진하지_않는지_테스트() {
        Car car = new Car("win");
        car.accelerate(2);

        assertTrue(car.isEqualPosition(0));
    }

    @Test
    void 자동차_클래스의_toString메소드가_제대로_동작하는지_검사() {
        Car car = new Car("red");
        car.accelerate(6);
        car.accelerate(6);
        car.accelerate(6);

        assertEquals(car.toString(), "red   : ---");
    }

    @Test
    void 자동차_클래스의_clone메소드가_제대로_동작하는지_검사() {
        Car car = new Car("red");
        car.accelerate(7);

        try {
            Car cloneCar = car.clone();
            assertTrue(car.equals(cloneCar));
            assertTrue(cloneCar.isEqualPosition(1));
            assertTrue(car != cloneCar);
        } catch (CloneNotSupportedException e) {
            System.out.println("생성 실패");
        }
    }
}