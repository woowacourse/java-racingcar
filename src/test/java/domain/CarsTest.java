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
    @DisplayName("우승자의 위치를 숫자로 반환한다.")
    void getWinnerLocation() {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        Cars cars = new Cars(Arrays.asList(one, two, three));

        //when
        three.move(4);
        three.move(4);
        three.move(4);

        //then
        assertThat(cars.getWinnerLocation()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자들을 리스트에 넣어 반환한다.")
    void getWinners() {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        Cars cars = new Cars(Arrays.asList(one, two, three));

        //when
        one.move(4);
        one.move(4);
        one.move(4);
        three.move(4);
        three.move(4);
        three.move(4);

        //then
        assertThat(cars.getWinners(cars.getWinnerLocation()).get(0)).isEqualTo(one);
        assertThat(cars.getWinners(cars.getWinnerLocation()).get(1)).isEqualTo(three);
    }
}
