package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CarTest {
    @Test
    @DisplayName("Car 클래스를 검사")
    void carTest() {
        Car car = new Car("pobi");
    }

    @ParameterizedTest
    @DisplayName("car가 4 이상의 숫자를 받을 때만 전진한다")
    @ValueSource(ints = {0, 1, 2, 3})
    void doesCarProceed(int value) {
        Car car = new Car("hiro");
        assertFalse(car.canMove(value));
    }

    @ParameterizedTest
    @DisplayName("이름의 5자 제한을 체크하는 부분")
    @ValueSource(strings = {"abcdef", ""})
    void checkCarNameException(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("Car의 Proceed 테스트")
    void carProceedTest() {
        Car car = new Car("hiro");
        for (int i = 0; i < 4; i++) {
            car.proceed();
        }
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("car의 전진 여부를 결정하는 난수 범위를 체크한다.")
    @ValueSource(ints = {10, -1})
    void randomGeneratorTest(int number) {
        Car car = new Car("hiro");
        Random random = new Random();
        assertThatThrownBy(() -> {
            car.canMove(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위를 초과");
    }

    @ParameterizedTest
    @DisplayName("Car끼리 private변수인 position을 비교하는 것을 테스트")
    @CsvSource(value = {"4,10,hiro", "12,10,asdf"})
    void checkPositionCompare(int car1Position, int car2Position, String winnerName) {
        Car car1 = new Car("asdf");
        Car car2 = new Car("hiro");
        for (int i = 0; i < car1Position; i++) {
            car1.proceed();
        }
        for (int i = 0; i < car2Position; i++) {
            car2.proceed();
        }
        assertThat(car1.comparePosition(car2)
                .getName()).isEqualTo(winnerName);
    }

    @Test
    @DisplayName("우승자가 정해진 경우 추가 우승자를 찾음")
    void findMoreWinners() {
        Car winnerCar = new Car("alan");
        Car car2 = new Car("bart");
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            winnerCar.canMove(4);
            car2.canMove(4);
        }
        assertThat(winnerCar.checkMoreWinners(car2, winner)).containsExactly("bart");
    }
}
