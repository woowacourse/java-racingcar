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
        assertThat(carGenerator.generateCars("pobi,,,crong".split(","))).isEqualTo(cars);
    }
}