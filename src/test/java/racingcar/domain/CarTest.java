package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("자동차")
class CarTest {
    @Nested
    @DisplayName("이름을 갖고 있는 자동차를 생성하면, ")
    class CreateCar {
        @Test
        @DisplayName("해당 이름을 저장한다.")
        public void createCarTest() {
            //given
            String name = "chocochip";

            //when
            Car car = new Car(name);

            //then
            assertEquals(car.getName(), name);
        }

        @Test
        @DisplayName("전진 거리가 0으로 생성된다.")
        public void verifyCarForward() {
            //given
            String name = "chocochip";
            int initialForward = 0;

            //when
            Car car = new Car(name);

            //then
            assertEquals(car.getForward(), initialForward);
        }
    }
}