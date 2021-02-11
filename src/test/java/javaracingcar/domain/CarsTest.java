package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    @DisplayName("Cars 객체 정상 생성")
    void generateCars() {
        List<String> names = Arrays.asList("CarA","CarB","CarC");
        Cars cars = new Cars(names);
        for (int i = 0; i < cars.toList().size(); i++) {
            assertEquals(new Car(names.get(i)), cars.toList().get(i));
        }
    }

    @Test
    @DisplayName("Cars 객체 중복된 이름")
    void constructCarsWithDuplicatedName() {
        List<String> carNames = Arrays.asList("a", "b", "c", "a");
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름");
    }

    @Test
    @DisplayName("Cars 객체 0개 입력")
    void constructCarsWithZeroName() {
        List<String> carNames = Collections.emptyList();
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 없습니다.");
    }


}