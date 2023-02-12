package model.car;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

class CarsTest {

    private Car gitJjang;
    private Car irene;

    @BeforeEach
    void setUp() {
        gitJjang = new Car("깃짱");
        irene = new Car("이리내");
    }

    @Test
    @DisplayName("자동차가 정상적으로 추가되는지 확인한다.")
    void carAddTest() {
        Cars cars = new Cars(List.of(gitJjang, irene));
        Assertions.assertTrue(cars.getCars().containsAll(Arrays.asList(gitJjang, irene)));
        Assertions.assertEquals(cars.getCars().size(), 2);
    }
}
