package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.model.Name;
import domain.repository.CarRaceResultRepositoryImpl;
import domain.service.CarRaceService;
import domain.service.CarRaceServiceImpl;
import domain.service.NumberGenerator;
import domain.service.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        carRaceService = makeCarRaceService(new RandomNumberGenerator());
        List<String> letters = List.of("car1", "car2");

        //when
        Map<Name, Integer> cars = carRaceService.saveCars(letters);

        //then
        List<Name> names = letters.stream().map(Name::new).collect(Collectors.toList());
        assertThat(cars.keySet()).containsAll(names);
    }

    @Test
    @DisplayName("모든 차를 이동시킨다")
    void moveCars() {
        //given
        carRaceService = makeCarRaceService(new TestMoveNumberGenerator());
        List<String> names = List.of("car1", "car2");
        carRaceService.saveCars(names);

        //when
        Map<Name, Integer> result = carRaceService.move();

        //then
        for (Integer raceResult : result.values()) {
            assertThat(raceResult).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("모든 차를 이동시키지 않는다.")
    void notMoveCars() {
        //given
        carRaceService = makeCarRaceService(new TestNotMoveNumberGenerator());
        List<String> names = List.of("car1", "car2");
        carRaceService.saveCars(names);

        //when
        Map<Name, Integer> result = carRaceService.move();

        //then
        for (Integer raceResult : result.values()) {
            assertThat(raceResult).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("차 개수 100개 초과일 경우")
    public void validateCarCount() {
        //given
        carRaceService = makeCarRaceService(new RandomNumberGenerator());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            names.add(String.valueOf(i));
        }

        //when
        //then
        assertThatThrownBy(() -> carRaceService.saveCars(names))
            .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("중복된 차 이름이 들어온 경우")
    public void duplicateCarNameSave() {
        //given
        carRaceService = makeCarRaceService(new RandomNumberGenerator());
        List<String> names = List.of("car", "car");
        
        //when
        //then
        assertThatThrownBy(() -> carRaceService.saveCars(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private CarRaceServiceImpl makeCarRaceService(NumberGenerator numberGenerator) {
        return new CarRaceServiceImpl(new CarRaceResultRepositoryImpl(), numberGenerator);
    }
}