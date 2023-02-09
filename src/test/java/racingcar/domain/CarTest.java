package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 도메인에 대한 테스트")
class CarTest {
    private Car car;
    TestNumberGenerator numberGenerator;

    @BeforeEach
    void setup() {
        car = new Car("pobi", 0);
    }

    @Nested
    @DisplayName("이동할 때")
    class WhenMove {
        @ParameterizedTest
        @ValueSource(ints = {4,5})
        @DisplayName("랜덤 숫자가 4이상이면 이동한다")
        void move(int number) {
            numberGenerator = new TestNumberGenerator(number);

            assertThat(car.move(numberGenerator).getCurrentPosition())
                    .isEqualTo(1);
        }

        @ParameterizedTest
        @DisplayName("랜덤 숫자가 4미만이면 이동하지 않는다")
        @ValueSource(ints = {1,3})
        void notMove(int number) {
            numberGenerator = new TestNumberGenerator(number);

            assertThat(car.move(numberGenerator).getCurrentPosition())
                    .isEqualTo(0);
        }
    }

    @Test
    @DisplayName("현재 상태와 일치하는 DTO를 생성하는지 확인한다")
    void getCarStatusCompletely() {
        int numberCanMove = 9;
        int moveCount = 5;
        numberGenerator = new TestNumberGenerator(numberCanMove);
        for(int i = 0; i < moveCount; i++) {
            car.move(numberGenerator);
        }

        assertThat(car.getCarStatus().getName())
                .isEqualTo(car.getName());
        assertThat(car.getCarStatus().getCurrentPosition())
                .isEqualTo(moveCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,-3", "1,-1", "0,0"})
    @DisplayName("자동차 위치 비교를 정확하게 하는지 검증한다.")
    void compareToTest(int otherPosition, int expected) {
        Car other = new Car("crong", otherPosition);

        assertThat(car.compareTo(other))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("isMovable에 대한 테스트")
    @CsvSource(value = {"3,false", "0,true"})
    void isSamePositionTest(int targetPosition, boolean expected) {
        Car other = new Car("crong", targetPosition);

        assertThat(car.isSamePosition(other))
                .isEqualTo(expected);
    }
}