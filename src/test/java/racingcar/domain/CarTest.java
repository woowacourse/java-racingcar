package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;
    TestNumberGenerator numberGenerator;

    @BeforeEach
    void setup() {
        car = new Car("pobi");
    }

    @Nested
    @DisplayName("이동할 때")
    class WhenMove {
        @ParameterizedTest
        @ValueSource(ints = {4, 5})
        @DisplayName("랜덤 숫자가 4이상이면 이동한다")
        void move(int number) {
            numberGenerator = new TestNumberGenerator(number);
            car.move(numberGenerator);

            assertThat(car.getCurrentPosition().getPosition())
                    .isEqualTo(1);
        }

        @ParameterizedTest
        @DisplayName("랜덤 숫자가 4미만이면 이동하지 않는다")
        @ValueSource(ints = {1, 3})
        void notMove(int number) {
            numberGenerator = new TestNumberGenerator(number);
            car.move(numberGenerator);

            assertThat(car.getCurrentPosition().getPosition())
                    .isEqualTo(0);
        }
    }

    @Test
    @DisplayName("현재 상태와 일치하는 위치와 이름을 반환하는지 확인한다")
    void getCarStatusCompletely() {
        int numberCanMove = 9;
        int moveCount = 5;
        numberGenerator = new TestNumberGenerator(numberCanMove);
        for (int i = 0; i < moveCount; i++) {
            car.move(numberGenerator);
        }

        assertThat(car.getCarName())
                .isEqualTo(car.getCarName());
        assertThat(car.getCurrentPosition().getPosition())
                .isEqualTo(moveCount);
    }

    @ParameterizedTest
    @DisplayName("isMovable에 대한 테스트")
    @CsvSource(value = {"3,false", "0,true"})
    void isSamePositionTest(int targetPosition, boolean expected) {
        Car other = new Car("crong");
        numberGenerator = new TestNumberGenerator(8);
        for (int i = 0; i < targetPosition; i++) {
            other.move(numberGenerator);
        }

        assertThat(car.isSamePosition(other.getCurrentPosition()))
                .isEqualTo(expected);
    }
}