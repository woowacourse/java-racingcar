package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car("test");
    }

    @DisplayName("0 ~ 3의 값일때는 움직이지 않는다.")
    @Test
    void moveTest1() {
        //given
        List<Integer> numbers = List.of(0, 1, 2, 3);

        //when
        for (int number : numbers) {
            car.move(number);
        }

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("4 ~ 9의 값일때는 움직인다.")
    @Test
    void moveTest2() {
        //given
        List<Integer> numbers = List.of(4, 5, 6, 7, 8, 9);

        //when
        for (int number : numbers) {
            car.move(number);
        }

        //then
        assertThat(car.getPosition()).isEqualTo(6);
    }
}