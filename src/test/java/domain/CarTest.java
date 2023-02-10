package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vo.Name;
import vo.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void checkConstructor() {
        Name expected = Name.of("test");
        Car car = new Car(expected);

        Name result = car.getName();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Car 이름이 5글자 넘으면 예외발생")
    void checkFailTest() {
        assertThatThrownBy(() -> new Car(Name.of("testTest")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}이 들어올때 테스트")
    @CsvSource(value = {"4,1", "3,0"})
    void checkMoveTest(int randomNumber, long expected) {
        Car car = new Car(Name.of("test"));
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(Position.of(expected));
    }
}