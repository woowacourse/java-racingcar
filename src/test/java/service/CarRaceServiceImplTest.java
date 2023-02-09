package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CarRaceResultRepositoryImpl;

class CarRaceServiceImplTest {

    private CarRaceService carRaceService;

    static class TestMoveNumberGenerator implements NumberGenerator {

        @Override
        public int generateNumber(int maxNumber) {
            return 4;
        }
    }

    static class TestNotMoveNumberGenerator implements NumberGenerator {

        @Override
        public int generateNumber(int maxNumber) {
            return 3;
        }
    }

    @Test
    @DisplayName("차 저장을 테스트한다")
    void saveCars() {
        //given
        carRaceService = new CarRaceServiceImpl(
            new CarRaceResultRepositoryImpl(), new RandomNumberGenerator());
        List<String> names = List.of("car1", "car2");

        //when
        Map<String, Integer> cars = carRaceService.saveCars(names);

        //then
        assertThat(cars.keySet()).containsAll(names);
    }

    @Test
    @DisplayName("모든 차를 이동시킨다")
    void moveCars() {
        //given
        carRaceService = new CarRaceServiceImpl(new CarRaceResultRepositoryImpl(),
            new TestMoveNumberGenerator());
        List<String> names = List.of("car1", "car2");
        carRaceService.saveCars(names);

        //when
        Map<String, Integer> result = carRaceService.move();

        //then
        for (Integer raceResult : result.values()) {
            assertThat(raceResult).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("모든 차를 이동시키지 않는다.")
    void notMoveCars() {
        //given
        carRaceService = new CarRaceServiceImpl(new CarRaceResultRepositoryImpl(),
            new TestNotMoveNumberGenerator());
        List<String> names = List.of("car1", "car2");
        carRaceService.saveCars(names);

        //when
        Map<String, Integer> result = carRaceService.move();

        //then
        for (Integer raceResult : result.values()) {
            assertThat(raceResult).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("차 개수 100개 초과일 경우")
    public void validateCarCount() {
        //given
        carRaceService = new CarRaceServiceImpl(new CarRaceResultRepositoryImpl(),
            new RandomNumberGenerator());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            names.add(String.valueOf(i));
        }

        //when
        //then
        assertThatThrownBy(() -> carRaceService.saveCars(names))
            .isInstanceOf(IllegalArgumentException.class);
    }
}