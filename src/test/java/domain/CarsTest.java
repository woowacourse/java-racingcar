package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", ""})
    @DisplayName("참여자가 2명 이하면 예외가 발생한다")
    void participantTest(String carName) {
        assertThatCode(() -> new Cars(List.of(new Car(carName))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,a,b", "ho,ha,ho"})
    @DisplayName("자동차 이름에 중복이 있으면 예외가 발생한다")
    void participantTest(String name1, String name2, String name3) {
        assertThatCode(() -> new Cars(List.of(new Car(name1),
                new Car(name2),
                new Car(name3))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("각 자동차를 조건에 맞춰 이동한다")
    void moveCarsTest() {
        //given
        Car one = new Car("one", 0);
        Car two = new Car("two", 0);
        Car three = new Car("three", 0);
        Cars cars = new Cars(Arrays.asList(one, two, three));

        //when
        cars.moveCars(new FixedNumberGenerator());

        //then
        for (Car car : cars.getCars()) {
            assertThat(car.getLocation()).isEqualTo(1);
        }
    }
}
