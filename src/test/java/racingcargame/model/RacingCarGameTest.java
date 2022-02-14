package racingcargame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarGameTest {
/*
    @Test
    void 입력받은_자동차_개수_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("gl");
        Cars carRepository = new Cars(carNames);

        assertThat(carRepository.getCars().size()).isEqualTo(2);
    }
*/
    @Test
    void 입력받은_경주_회수_테스트() {
        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList("a", "b", "c"), 5);
        assertThat(RaceCount.getCount()).isEqualTo(5);
    }

    @Test
    void 경주_회수_감소_테스트() {
        RacingCarGame racingCarGame = new RacingCarGame(Arrays.asList("a", "b", "c"), 5);
        RaceCount.reduceRaceCount();
        assertThat(RaceCount.getCount()).isEqualTo(4);
    }
/*
    @Test
    void 우승자_선발_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("liver");
        carNames.add("gl");

        Cars carRepository = new Cars(carNames);
        carRepository.getCars().stream()
                .filter(car -> car.getName().equals("liver"))
                .forEach(car -> car.setPosition(4));

        assertThat(carRepository.findWinner().get(0)).isEqualTo("liver");
    }

 */
}