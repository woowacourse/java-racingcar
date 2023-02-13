package output;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputsTest {

    private Car carA;
    private Car carB;
    private Car carC;
    private Cars cars;
    private Outputs outputs;

    @BeforeEach
    void init() {
        carA = new Car("carA");
        carB = new Car("carB");
        carC = new Car("carC");

        carB.move();
        carC.move();

        cars = new Cars(List.of(
                carA,
                carB,
                carC
        ));

        outputs = Outputs.from(cars);
    }

    @Test
    void fromTest() {
        List<String> names = outputs.getOutputs()
                .stream()
                .map(Output::getName)
                .collect(Collectors.toList());

        assertThat(names).containsExactly("carA", "carB", "carC");

        List<Integer> positions = outputs.getOutputs()
                .stream()
                .map(Output::getPosition)
                .collect(Collectors.toList());

        assertThat(positions).containsExactly(0, 1, 1);
    }
}
