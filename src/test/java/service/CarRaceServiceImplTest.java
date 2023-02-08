package service;

import java.util.List;
import java.util.Map;
import model.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CarRaceResultRepositoryImpl;
import util.RandomNumberGenerator;
import util.RandomNumberGeneratorImpl;

class CarRaceServiceImplTest {

    private CarRaceService carRaceService;
    private static final List<String> names = List.of("car1", "car2");

    static class TestMoveRandomNumberGenerator implements RandomNumberGenerator {

        @Override
        public int generateRandomNumber(int maxNumber) {
            return 4;
        }
    }

    static class TestNotMoveRandomNumberGenerator implements RandomNumberGenerator {

        @Override
        public int generateRandomNumber(int maxNumber) {
            return 3;
        }
    }

    @BeforeAll
    static void setUp() {
        for (String name : names) {
            CarRaceResultRepositoryImpl.getInstance().save(new Car(name));
        }
    }


    @Test
    @DisplayName("차 저장을 테스트한다")
    void saveCars() {
        //given
        this.carRaceService = new CarRaceServiceImpl(
            CarRaceResultRepositoryImpl.getInstance(), new RandomNumberGeneratorImpl());
        List<String> names = List.of("car3", "car4");

        //when
        Map<String, Integer> cars = carRaceService.saveCars(names);

        //then
        Assertions.assertThat(cars.keySet()).containsAll(names);
    }

    @Test
    @DisplayName("모든 차를 이동시킨다")
    void moveCars() {
        //given
        carRaceService = new CarRaceServiceImpl(CarRaceResultRepositoryImpl.getInstance(),
            new TestMoveRandomNumberGenerator());

        //when
        Map<String, Integer> result = carRaceService.move();

        //then
        for (Integer raceResult : result.values()) {
            Assertions.assertThat(raceResult).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("모든 차를 이동시키지 않는다.")
    void notMoveCars() {
        //given
        carRaceService = new CarRaceServiceImpl(CarRaceResultRepositoryImpl.getInstance(),
            new TestNotMoveRandomNumberGenerator());

        //when
        Map<String, Integer> result = carRaceService.move();

        //then
        for (Integer raceResult : result.values()) {
            Assertions.assertThat(raceResult).isEqualTo(2);
        }
    }

}