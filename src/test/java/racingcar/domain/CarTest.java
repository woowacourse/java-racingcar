package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("정상적인 이름이 들어왔을 떄 Car가 잘 생성되는지")
    @Test
    void carConstructor_properName_createCar() {
        Name name = new Name("포비");
        Car car = new Car(name);

        assertThat(car).isInstanceOf(Car.class)
                .isEqualTo(new Car(name));
//        assertThat(car.getName()).isEqualTo(name);
//        assertThat(car.getPosition()).isEqualTo(INIT_POSITION);
    }

    @DisplayName("적합한 이름과 포지션이 둘다 주어졌을떄 Car가 잘 생성되는지")
    @Test
    void carConstructor_properNameAndPosition_createCar() {
        Name name = new Name("데이브");
        Position position = new Position(4);
        Car car = new Car(name, position);

        assertThat(car).isInstanceOf(Car.class)
                .isEqualTo(new Car(name, position));
    }

    @DisplayName("주어진 숫자에 따라 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({"2,false", "3,false", "4,true", "5,true"})
    void move_givenNumberToMoveCars_moveAccordingToNumber(int given, boolean result) {
        Car car = new Car(new Name("TEST"));
        car.move(given);

        assertThat(car.getPosition().equals(new Position(1))).isEqualTo(result);
    }
}