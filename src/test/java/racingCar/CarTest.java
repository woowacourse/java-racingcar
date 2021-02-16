package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CarTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        car1 = new Car("test");
        car2 = new Car("car2");

        car2.move(4);
        car2.move(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    @DisplayName("랜덤값으로 입력되는 값이 4이상일경우 전진 아닐경우 정지인지 확인")
    public void move(int input, int expected) {
        Car car3 = new Car("car3");
        car3.move(input);
        assertThat(car3.getDistance()).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자의 max 이동거리를 이용하여 우승자인지 확인하는 테스트")
    public void isWinnerTest() {
        assertTrue(car1.isWinner(0));
        assertFalse(car1.isWinner(2));
        assertTrue(car2.isWinner(2));
    }
}
