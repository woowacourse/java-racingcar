package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("정상적인 차 이름들을 받았을 경우")
    void validateNames() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        List<String> names = new ArrayList<>();

        for (Car car : cars.getCarList()) {
            names.add(car.getName());
        }

        assertThat(names).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("빈 배열을 차 이름들로 받았을 경우")
    void validateNamesEmpty() {
        assertThatThrownBy(() -> {
            new Cars(Arrays.asList());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}