package view;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        cars.get(0).moveOrNot(9);
        cars.get(0).moveOrNot(9);
        cars.get(1).moveOrNot(9);
        cars.get(2).moveOrNot(3);
    }

    @DisplayName("포지션 값만큼 '-' 출력")
    @ParameterizedTest
    @CsvSource(value = {"0,'--'", "1,'-'", "2,''"})
    void visualizePosition(int index, String s) {
        String result = OutputView.printPositionBar(cars.get(index));
        assertThat(result).isEqualTo(s);
    }
}
