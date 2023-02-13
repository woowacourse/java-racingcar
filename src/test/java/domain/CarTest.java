package domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vo.CarName;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Nested
    @Disabled("모든 검증 작업을 CarName 객체 생성 시에 진행하는데," +
            "CarNameTest에서 해당 작업을 이미 하고 있으므로 테스트 코드를 따로 작성하지 않습니다.")
    class ValidationTest {}

    @Nested
    @DisplayName("객체 정보 테스트")
    class CarInformationTest {
        @Test
        @DisplayName("Car 객체는 생성자로 접근이 불가능하고, 정적 메소드 of() 를 통해 생성할 수 있다.")
        void givenName_whenMakingCar_thenReturnsCar() {
            String expected = "test";

            Car car = Car.of(CarName.of(expected));

            assertThat(car).isNotNull();
        }

        @Test
        @DisplayName("Car 객체 생성시, 인자로 넘어온 carName 값을 이름으로 가지고 있다.")
        void givenName_whenGettingName_thenReturnsNameString() {
            String expected = "test";

            Car car = Car.of(CarName.of(expected));

            assertThat(car.getName())
                    .as("getName() 호출시 원시값을 반환한다.")
                    .isOfAnyClassIn(String.class)
                    .isEqualTo(expected);
        }

        @Test
        @DisplayName("Car 객체 생성시, position 필드의 초기값은 0이다.")
        void givenCar_whenGettingPosition_thenReturnsPositionNumber() {
            Car car = Car.of(CarName.of("test"));

            assertThat(car.getPosition())
                    .as("getPosition() 호출시 원시값을 반환한다.")
                    .isOfAnyClassIn(Long.class)
                    .isEqualTo(0L);
        }
    }

    @Nested
    @DisplayName("자동차의 이동 정도를 증가시키는 move() 메소드 테스트")
    class MoveTest {
        @ParameterizedTest(name = "move() 메소드를 호출하여, 주어진 power 값({0})에 따라 position의 전진 여부 테스트")
        @CsvSource(value = {"4,1", "3,0"})
        void givenCar_whenMovingCar_thenAddsPosition(int power, long expected) {
            Car car = Car.of(CarName.of("test"));

            car.move(power);

            assertThat(car.getPosition())
                    .as("power 값이 4 이상이면 전진하고, 3 이하면 전진하지 않는다.")
                    .isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("Car 객체가 주어진 이동 정도를 가지고 있는 지 알아볼 때 사용하는 hasPosition() 메소드 테스트")
    class HasPositionTest {
        @ParameterizedTest()
        @CsvSource(value = {"4,true", "3,false"})
        @DisplayName("차가 주어진 이동 정도를 가지고 있는 지를 참 거짓 값으로 판단할 수 있다.")
        void givenPosition_whenAskingHasPosition_thenReturnsResult(Long position, boolean expected) {
            Car car = Car.of(CarName.of("Car"));
            for (int i = 0; i < 4; i++) {
                car.move(4);
            }

            assertThat(car.hasPosition(position)).isEqualTo(expected);
        }
    }
}