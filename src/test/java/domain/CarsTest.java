package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;
    @BeforeEach
    void setUp() {
        cars = new Cars();
        String[] carsName = {"car1", "car2", "car3"};
        cars.creatCar(carsName);
    }



    @DisplayName("우승자 리턴 테스트")
    @Test
    void powerInjectionAllCars() {
        List<String> result = cars.selectWinners();
        assertThat(result).isEqualTo(List.of("car1","car2","car3"));
    }
}