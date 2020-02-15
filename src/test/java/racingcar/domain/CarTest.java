package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private Car car;
    private static final String TEST_NAME = "pobi";

    @BeforeEach
    void setUp() {
        car = new Car(TEST_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiconnan","subway","sonypark"})
    void Throw_Error_When_CarName_isMoreThan_5(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi","metro","sony2"})
    void Not_Throw_Error_When_CarName_isLessThanOrEqualTo5_(String name) {
        Assertions.assertThatCode(()-> new Car(name)).doesNotThrowAnyException();

    }

    @Test
    void getCarNameAndPosition() {
        int position = 0;

        Assertions.assertThat(car).extracting("name", "position").contains(TEST_NAME, position);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void Should_move_when_bigger_than_3(int value, int expected) {
        RandomNo randomNo = new RandomNo(value);
        car.move(randomNo);

        Assertions.assertThat(car).extracting("position").isEqualTo(expected);
    }
}
