package model.car;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Car gitJjang = new Car("깃짱");
    private Car irene = new Car("이리내");

    @Test
    @DisplayName("자동차가 정상적으로 추가되는지 확인한다.")
    void carAddTest() {
        Cars cars = new Cars();
        cars.addCar(gitJjang);
        cars.addCar(irene);
        Assertions.assertTrue(cars.cars().containsAll(Arrays.asList(gitJjang, irene)));
        Assertions.assertEquals(cars.cars().size(), 2);
    }
}