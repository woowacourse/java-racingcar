package output;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("test");
    }

    @Test
    void fromTest() {
        Output output = Output.from(car);
        assertThat(output.getName()).isEqualTo("test");
        assertThat(output.getPosition()).isEqualTo(0);
    }

    @Test
    void outputNeverChangeTest() {
        car.move();
        Output output = Output.from(car);
        car.move();
        assertThat(output.getPosition()).isEqualTo(1);
    }
}
