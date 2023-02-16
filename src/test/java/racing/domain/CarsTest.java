package racing.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.ui.output.OutputView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        List<Car> carList = List.of(
                new Car("bebe0"),
                new Car("bebe1"),
                new Car("bebe2")
        );
        cars = new Cars(carList);
    }

    @DisplayName("출력 형식이 반환되어야 한다.")
    @Test
    void getPrintForm() {
        cars.getCar(0).move();
        List<String> printForms = this.cars.getPrintForm();

        Assertions.assertAll(
                () -> assertEquals(printForms.get(0), "bebe0" + OutputView.COLON + OutputView.HYPHEN.repeat(1)),
                () -> assertEquals(printForms.get(1), "bebe1" + OutputView.COLON + OutputView.HYPHEN.repeat(0)),
                () -> assertEquals(printForms.get(2), "bebe2" + OutputView.COLON + OutputView.HYPHEN.repeat(0))
        );
    }

    @DisplayName("경기 승자를 반환해야 한다.")
    @Test
    void getWinners() {
        cars.getCar(0).move();
        cars.getCar(1).move();
        cars.getCar(1).move();
        cars.getCar(2).move();
        cars.getCar(2).move();
        assertEquals(cars.getWinners(), List.of("bebe1", "bebe2"));
    }
}