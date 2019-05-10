package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarGeneratorTest {
    CarGenerator carGenerator;

    @BeforeEach
    void setUp() {
        carGenerator = new CarGenerator();
    }

    @Test
    void create() {
        assertThat(carGenerator.equals(new CarGenerator())).isTrue();
    }

    @Test
    void 차생성_테스트(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        assertThat(carGenerator.generateCars2("pobi,,,crong".split(",")).equals(cars)).isTrue();
    }

    @Test
    void 자동차리스트가_잘저장되는지_테스트(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));

        carGenerator.generateCars("pobi,crong".split(","));
        assertThat(carGenerator.getCars().equals(cars)).isTrue();
    }
}