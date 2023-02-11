package model.car;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {

    private Car gitJjang = new Car("깃짱");
    private Car irene = new Car("이리내");

    @Test
    @DisplayName("자동차가 정상적으로 추가되는지 확인한다.")
    void carAddTest() {
        CarRepository carRepository = new CarRepository();
        carRepository.addCars(gitJjang);
        carRepository.addCars(irene);
        Assertions.assertTrue(carRepository.cars().containsAll(Arrays.asList(gitJjang, irene)));
        Assertions.assertEquals(carRepository.cars().size(), 2);
    }
}