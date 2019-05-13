package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_생성자가_이름을_기반으로_정상적으로_작동하는지_테스트() {
        assertEquals(new Car("green"), new Car("green"));
    }

    @Test
    void 이름의_길이가_기준치에_맞지_않으면_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("banana");
        });
    }

    @Test
    void 자동차가_기준치_이상의_값에서_전진하는지_테스트() {
        Car car = new Car("win");
        boolean isAccelerated = car.accelerate(4);

        assertTrue(isAccelerated);
        assertTrue(car.isEqualPosition(1));
    }

    @Test
    void 자동차가_기준치_미만의_값에서_전진하지_않는지_테스트() {
        Car car = new Car("win");
        boolean isAccelerated = car.accelerate(3);

        assertFalse(isAccelerated);
        assertTrue(car.isEqualPosition(0));
    }

    @Test
    void toString_메소드가_제대로_동작하는지_테스트() {
        Car car = new Car("red", 3);

        assertEquals(car.toString(), "red   : ---");
    }

    @Test
    void clone_메소드가_제대로_동작하는지_테스트() {
        Car car = new Car("red", 1);

        try {
            Car copiedCar = car.clone();
            assertEquals(copiedCar, car);
            assertTrue(copiedCar.isEqualPosition(1));
        } catch (CloneNotSupportedException e) {
            System.out.println("생성 실패");
        }
    }
}