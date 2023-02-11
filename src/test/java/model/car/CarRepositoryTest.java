package model.car;

import java.util.Arrays;

import org.junit.jupiter.api.*;

class CarRepositoryTest {

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
        CarRepository.addCars(gitJjang);
        CarRepository.addCars(irene);
        Assertions.assertTrue(CarRepository.cars().containsAll(Arrays.asList(gitJjang, irene)));
        Assertions.assertEquals(CarRepository.cars().size(), 2);
    }

    @AfterEach
    static void afterAll() {
        CarRepository.deleteAll();
    }
}
