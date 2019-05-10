package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private Cars cars;
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("pobi", "crong", "ex");
        cars = new Cars(carNames);
    }

    @Test
    void 자동차들_객체_생성() {
        List<Car> carsOnRace = new ArrayList<>();
        for(String car : carNames){
            carsOnRace.add(new Car(car));
        }
        assertThat(cars.createCars()).isEqualTo(carsOnRace);
    }

    @Test
    void 자동차들_객체_생성_중복_예외_처리() {
        List<String> duplicatedCarNames = Arrays.asList("pobi", "pobi", "pobi");
        cars = new Cars(duplicatedCarNames);
        assertThrows(IllegalArgumentException.class, () -> {
            cars.createCars();
        });
    }

    @Test
    void 자동차들_객체_생성_없는_값_예외_처리() {
        List<String> notExistedCarNames = new ArrayList<>();
        cars = new Cars(notExistedCarNames);
        assertThrows(IllegalArgumentException.class, () -> {
            cars.createCars();
        });
    }

    @AfterEach
    void tearDown() {
        carNames = null;
        cars = null;
    }
}