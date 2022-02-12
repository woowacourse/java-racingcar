package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

    @Test
    void 입력받은_자동차_개수_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("lawn");
        CarRepository carRepository = new CarRepository(carNames);

        assertThat(carRepository.getCars().size()).isEqualTo(2);
    }

    @Test
    void 우승자_선발_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("lawn");

        CarRepository carRepository = new CarRepository(carNames);
        carRepository.moveCars();

        assertThat(carRepository.findWinner().get(0).contains("liver")
                || carRepository.findWinner().get(0).contains("lawn")).isTrue();
    }
}