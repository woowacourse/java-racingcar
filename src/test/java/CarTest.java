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

    @ParameterizedTest(name = "{0}을 이름으로 사용하면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "123456"})
    void illegalNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null을 이름으로 사용하면 예외가 발생한다.")
    void nullNameExceptionTest() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //TODO : Car.tryMove 테스트
}