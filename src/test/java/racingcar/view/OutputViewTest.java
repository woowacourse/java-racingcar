package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameManager;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class OutputViewTest {
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        GameManager.moveOrStay(cars.get(0), 9);
        GameManager.moveOrStay(cars.get(0), 9);
        GameManager.moveOrStay(cars.get(1), 9);
        GameManager.moveOrStay(cars.get(1), 9);
    }

    @DisplayName("포지션 값만큼 '-' 출력")
    @Test
    void visualizePosition() {
        String result = OutputView.printPositionBar(cars.get(0));
        assertThat(result).isEqualTo("--");
    }

}
