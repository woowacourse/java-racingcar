package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("이름이 5글자 이하일 때 Car 객체가 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"benz", "bmw", "suv"})
    void carNameTest(String text) {
        Car car = new Car(text);
        assertThat(car.getName()).isEqualTo(text);
    }

    @DisplayName("이름이 6글자 이상일 때 Car 객체 생성 시 에러 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"grandeur", "sportsCar", "sonata"})
    void carNameLengthErrorTest(String text) {
        assertThatThrownBy(() -> {
            new Car(text);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("위치값이 음수 일때 에러 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void negativeNumberPositionErrorTest(int number) {
        assertThatThrownBy(() -> {
            new Car("temp", number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 값이 4이상 일때 자동차 위치가 변하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"9:1", "3:0", "4:1"}, delimiter = ':')
    void randomNumberPositionTest(int input, int expected) {
        Car car = new Car("temp");
        car.move(() -> input);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("위치값이 문자열로 잘 변환되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:---", "2:--", "5:-----"}, delimiter = ':')
    void carPositionToStringTest(int input, String expected) {
        Car car = new Car("temp", input);
        assertThat(OutputView.positionToHyphen(car)).isEqualTo(expected);
    }

    @DisplayName("범위에 맞는 랜덤 값이 생성하는지 테스트")
    @Test
    void randomValueRangeTest() {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        for (int i = 0; i < 10000; i++) {
            assertThat(randomValueGenerator.createMoveValue()).isBetween(0, 9);
        }
    }
}
