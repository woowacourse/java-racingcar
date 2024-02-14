package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차")
class CarTest {
    @Test
    @DisplayName("이름을 갖고 있는 자동차를 생성하면, 해당 이름을 저장한다.")
    public void createCarTest() {
        //given
        String name = "choco";

        //when
        Car car = new Car(name);

        //then
        assertEquals(car.getName(), name);
    }

    @Test
    @DisplayName("이름을 갖고 있는 자동차를 생성하면, 전진 거리가 0으로 생성된다.")
    public void verifyCarForward() {
        //given
        String name = "choco";
        int initialForward = 0;

        //when
        Car car = new Car(name);

        //then
        assertEquals(car.getForward(), initialForward);
    }


    @DisplayName("적절하지 않은 이름은 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"chocochip"})
    public void testInvalidName(String name) {
        //given & when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
}