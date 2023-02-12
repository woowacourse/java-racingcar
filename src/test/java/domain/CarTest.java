package domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("joy");
    }

    @DisplayName("차량의 이름은 공백없이 1~5자로 입력 가능하고, 그렇지 않다면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "ronaldo", "joy "})
    void nameTest(String name) {
        assertThatThrownBy(
            () -> new Car(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 숫자가 4이상이면 자동차가 움직이고, 3이하이면 움직이지 않는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1", "9:1"}, delimiter = ':')
    void moveTest(int number, int expected) {
        car.move(number);
        assertEquals(expected, car.getPosition());
    }


    @DisplayName("차의 현재 상태를 String 으로 반환한다.")
    @Test
    void getCarStatusTest() {
        car.move(4);
        Assertions.assertEquals(car.getCarStatus(),
            "joy : -");
    }
}