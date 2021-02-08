package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"benz", "bmw", "suv"})
    @DisplayName("이름이 5글자 이하일 때 Car 객체가 생성되는지 테스트")
    void carNameTest(String text) {
        Car car = new Car(text);
        assertThat(car.getName()).isEqualTo(text);
    }

    @ParameterizedTest
    @ValueSource(strings = {"grandeur", "sportsCar", "sonata"})
    @DisplayName("이름이 6글자 이상일 때 Car 객체 생성 시 에러 발생하는지 테스트")
    void carNameLengthErrorTest(String text) {
        assertThatThrownBy(() -> {
            new Car(text);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"9:1", "3:0", "5:1"}, delimiter = ':')
    @DisplayName("랜덤 값이 4이상 일때 자동차 위치가 변하는지 테스트")
    void randomNumberPositionTest(String input, String expected) {
        Car car = new Car("temp");
        car.move(() -> Integer.parseInt(input));
        assertThat(car.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:---", "2:--", "5:-----"}, delimiter = ':')
    @DisplayName("위치값이 문자열로 잘 변환되는지 테스트")
    void carPositionToStringTest(String input, String expected) {
        Car car = new Car("temp");
        for (int i = 0; i < Integer.parseInt(input); i++) {
            car.move(() -> 4);
        }
        assertThat(car.positionToString()).isEqualTo(expected);
    }

    @Test
    @DisplayName("범위에 맞는 랜덤 값이 생성하는지 테스트")
    void randomValueRangeTest() {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        assertThat(randomValueGenerator.createMoveValue()).isBetween(0, 9);
    }
}
