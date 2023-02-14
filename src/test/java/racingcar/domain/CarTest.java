package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 도메인에 대한 테스트")
class CarTest {
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("pobi", 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,-3", "1,-1", "0,0"})
    @DisplayName("자동차 위치 비교를 정확하게 하는지 확인한다")
    void compareToTest(int otherPosition, int expected) {
        Car other = new Car("crong", otherPosition);

        assertThat(car.compareTo(other))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("다른 자동차와 위치값 비교를 정확히 하는지 확인한다")
    @CsvSource(value = {"3,false", "0,true"})
    void isSamePositionTest(int targetPosition, boolean expected) {
        Car other = new Car("crong", targetPosition);

        assertThat(car.isSamePosition(other))
                .isEqualTo(expected);
    }

    @Nested
    @DisplayName("이동할 때")
    class WhenMove {
        @ParameterizedTest
        @ValueSource(ints = {4, 5})
        @DisplayName("랜덤 숫자가 4이상이면 이동한다")
        void move(int number) {
            car.move(new TestNumberGenerator(number));

            assertThat(car.getCurrentPosition())
                    .isEqualTo(1);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 3})
        @DisplayName("랜덤 숫자가 4미만이면 이동하지 않는다")
        void notMove(int number) {
            car.move(new TestNumberGenerator(number));

            assertThat(car.getCurrentPosition())
                    .isEqualTo(0);
        }
    }

}
