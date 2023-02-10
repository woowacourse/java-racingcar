package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car("test");
    }

    @DisplayName("0 ~ 3의 값일때는 움직이지 않는다.")
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void moveTest1(int number) {
        //given

        //when
        car.move(number);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("4 ~ 9의 값일때는 움직인다.")
    @ParameterizedTest
    @CsvSource({"4", "5", "6", "7", "8", "9"})
    void moveTest2(int number) {
        //given

        //when
        car.move(number);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
