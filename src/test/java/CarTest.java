import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    Car car;

    @BeforeEach
    void setup() {
        car = new Car("pobi", new RandomNumberGenerator());
    }


    @Test
    @DisplayName("객체가 정상적으로 생성된다.")
    void createObjectTest() {
        assertThatCode(() -> new Car("pobi", new RandomNumberGenerator())).doesNotThrowAnyException();
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

    @ParameterizedTest(name = "{0}이면 전진하지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void dontMoveTest(int generatedValue) {
        NumberGenerator generator = new ConstantNumberGenerator(generatedValue);
        Car car = new Car("atto", generator);
        int prevLocation = car.getLocation();
        car.tryMove();
        assertThat(car.getLocation()).isEqualTo(prevLocation);
    }

    @ParameterizedTest(name = "{0}이면 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void doMoveTest(int generatedValue) {
        NumberGenerator generator = new ConstantNumberGenerator(generatedValue);
        Car car = new Car("atto", generator);
        int prevLocation = car.getLocation();
        car.tryMove();
        assertThat(car.getLocation()).isEqualTo(prevLocation + 1);
    }
}