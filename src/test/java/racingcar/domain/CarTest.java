package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("red");
    }

    @Test
    public void 이름이_null값일때() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car(null);
        });
    }

    @Test
    public void 위치가_음수일때() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("red", -1);
        });
    }

    @Test
    public void 이름의_길이가_기준치이상일때() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("banana");
        });
    }

    @Test
    public void 이름이_빈칸일때() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car("");
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Car(" ");
        });
    }

    @Test
    public void 생성자_검사() {
        Car actual = new Car("red");

        assertThat(car.equals(actual)).isTrue();
    }

    @Test
    public void 자동차가_전진() {
        car.accelerate(4);

        assertTrue(car.matchPosition(1));
    }

    @Test
    public void 자동차_정지() {
        car.accelerate(3);

        assertTrue(car.matchPosition(0));
    }

    @Test
    public void 자동차_클래스의_toString메소드가_제대로_동작하는지_검사() {
        car.accelerate(4);
        assertEquals("red   : -", car.toString());
    }

    @Test
    public void 자동차_클래스의_clone메소드가_제대로_동작하는지_검사() {
        car.accelerate(4);

        try {
            Car cloneCar = car.clone();
            assertTrue(car.equals(cloneCar));
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        car = null;
    }
}