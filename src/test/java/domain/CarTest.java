package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void 생성자_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    void 생성자_null() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 생성자_5글자초과() {
        assertThrows(IllegalArgumentException.class, () -> new Car("123456"));
    }

    @Test
    void positionComparator_위치동일할때() {
        int[] positions = new int[]{
                0, 1, 10, 100, 1000
        };

        for (int position : positions) {
            Car car1 = new Car("car1", position);
            Car car2 = new Car("car2", position);

            assertThat(Car.positionComparator.compare(car1, car2)).isEqualTo(0);
        }
    }

    @Test
    void positionComparator_앞이적은위치() {
        int[] positions = new int[]{
                0, 1, 10, 100, 1000
        };

        for (int position : positions) {
            Car car1 = new Car("car1", position - 1);
            Car car2 = new Car("car2", position);

            assertThat(Car.positionComparator.compare(car1, car2)).isNegative();
        }
    }

    @Test
    void positionComparator_앞이큰위치() {
        int[] positions = new int[]{
                0, 1, 10, 100, 1000
        };

        for (int position : positions) {
            Car car1 = new Car("car1", position);
            Car car2 = new Car("car2", position + 1);

            assertThat(Car.positionComparator.compare(car1, car2)).isNegative();
        }
    }
}