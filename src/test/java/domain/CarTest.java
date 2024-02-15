package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final Car car = new Car("abc");

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("abc");
    }

    @Test
    void getResult() {
        assertThat(car.getResult()).isEqualTo("abc : \n");
    }

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"}, delimiter = ',')
    void move(int randomNumber, int expect) {
        car.move(randomNumber);
        assertThat(car.getLocation()).isEqualTo(expect);
    }

    @Test
    void getLocation() {
        assertThat(car.getLocation()).isEqualTo(0);
    }
}