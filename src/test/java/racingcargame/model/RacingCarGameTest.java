package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

    @Test
    @DisplayName("생성한 자동차 객체 갯수 확인")
    void storeCarName() {
        List<String> carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("lawn");
        CarRepository carRepository = new CarRepository(carNames);

        assertThat(carRepository.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 확인")
    void findCarName() {
        List<String> carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("lawn");

        CarRepository carRepository = new CarRepository(carNames);
        carRepository.moveCars();

        assertThat(carRepository.findWinner().get(0).contains("liver")
                || carRepository.findWinner().get(0).contains("lawn")).isTrue();
    }
}