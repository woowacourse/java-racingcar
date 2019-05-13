package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarGeneratorTest {
    CarGenerator carGenerator;

    @BeforeEach
    void setUp() {
        carGenerator = new CarGenerator();
    }

    @Test
    void create() {
        assertThat(new CarGenerator()).isEqualTo(new CarGenerator());
    }

    @Test
    void 차생성(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        assertThat(carGenerator.generateCars("pobi,crong".split(",")).equals(cars)).isTrue();
    }

    @Test
    void 자동차리스트가_잘저장되는지(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));

        assertThat(carGenerator.generateCars("pobi,crong".split(",")).equals(cars)).isTrue();
    }
}