package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    private Car car;
    private static final CarName TEST_NAME = new CarName("pobi");

    @BeforeEach
    void setUp() {
        car = new Car(TEST_NAME);
    }

    @Test
    void getCarNameAndPosition() {
        int position = 0;

        Assertions.assertThat(car).extracting("name", "position").contains(TEST_NAME, position);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void Should_move_when_bigger_than_3(int value, int expected) {
        MoveNumber moveNumber = new MoveNumber(value);
        car.move(moveNumber);

        Assertions.assertThat(car).extracting("position").isEqualTo(expected);
    }
}
