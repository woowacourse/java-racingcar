package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    @DisplayName("Cars 객체 정상 생성")
    void generateCars() {
        List<String> names = Arrays.asList("CarA", "CarB", "CarC");
        Cars cars = Cars.createByName(names);
        for (int i = 0; i < cars.toList()
                                .size(); i++) {
            assertEquals(new Car(names.get(i)), cars.toList()
                                                    .get(i));
        }
    }

    @Test
    @DisplayName("Cars 객체 중복된 이름")
    void constructCarsWithDuplicatedName() {
        List<String> carNames = Arrays.asList("a", "b", "c", "a");
        assertThatThrownBy(() -> Cars.createByName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름");
    }

    @Test
    @DisplayName("Cars 객체 0개 입력")
    void constructCarsWithZeroName() {
        List<String> carNames = Collections.emptyList();
        assertThatThrownBy(() -> Cars.createByName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 없습니다.");
    }

    @Test
    @DisplayName("최대 포지션 검증")
    void getMaxPositionTest() {
        Car carA = new Car("CarA",3);
        Car carB = new Car("CarB",2);
        Car carC = new Car("CarC",1);
        Cars cars = new Cars(Arrays.asList(carA,carB,carC));
        assertEquals(3, cars.getMaxPosition());
    }

    @Test
    @DisplayName("위치에 맞는 Car list")
    void atPositionTest() {
        Car carA = new Car("CarA",3);
        Car carB = new Car("CarB",3);
        Car carC = new Car("CarC",2);
        Cars cars = new Cars(Arrays.asList(carA,carB,carC));
        List<Car> carsAtPositionThree = cars.atPosition(3);
        assertTrue(carsAtPositionThree.contains(carA));
        assertTrue(carsAtPositionThree.contains(carB));
        assertFalse(carsAtPositionThree.contains(carC));
    }
}