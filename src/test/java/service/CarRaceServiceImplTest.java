package service;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CarRaceResultRepositoryImpl;

class CarRaceServiceImplTest {

    private final CarRaceService carRaceService = new CarRaceServiceImpl(
        CarRaceResultRepositoryImpl.getInstance());

    @Test
    @DisplayName("차 저장을 테스트한다")
    void saveCars() {
        //given
        List<String> carNames = List.of("car1", "car2");

        //when
        Map<String, Integer> cars = carRaceService.saveCars(carNames);

        //then
        Assertions.assertThat(cars.keySet()).containsAll(carNames);
    }
}