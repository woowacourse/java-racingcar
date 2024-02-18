import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.NumberGenerator;
import utils.Random;

class CarTest {

    Car car;

    @BeforeEach
    void setup() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("객체가 정상적으로 생성된다.")
    void createObjectTest() {
        assertThatCode(() -> new Car("pobi")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("초기 이름이 정상적으로 설정된다.")
    void checkInitNameTest() {
        String expectedName = "pobi";
        assertThat(car.getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("초기 위치가 0으로 설정된다.")
    void checkInitLocationTest() {
        int expectedLocation = 0;
        assertThat(car.getLocation()).isEqualTo(expectedLocation);
    }

    @ParameterizedTest(name = "공백을 이름으로 사용하면 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    void blankNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 공백입니다.");
    }

    @Test
    @DisplayName("이름의 길이가 5자를 초과하면 예외가 발생한다.")
    void longNameExceptionTest() {
        assertThatThrownBy(() -> new Car("zangsu"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("null을 이름으로 사용하면 예외가 발생한다.")
    void nullNameExceptionTest() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 입력되지 않았습니다.");
    }

    @ParameterizedTest(name = "{0}이면 전진하지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void dontMoveTest(int moveValue) {
        Car car = new Car("atto");
        int prevLocation = car.getLocation();
        car.tryMove(moveValue);
        assertThat(car.getLocation()).isEqualTo(prevLocation);
    }

    @ParameterizedTest(name = "{0}이면 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void doMoveTest(int moveValue) {
        Car car = new Car("atto");
        int prevLocation = car.getLocation();
        car.tryMove(moveValue);
        assertThat(car.getLocation()).isEqualTo(prevLocation + 1);
    }
}
