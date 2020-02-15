package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingResultsTest {

    private static RacingResults racingResults = new RacingResults();
    private static Car car1 = new Car(new CarName("하나"));
    private static Car car2 = new Car(new CarName("두울"));

    @BeforeAll
    static void makeRacingResultFactory() {
        Map<Car, Integer> racingCarResult1 = new LinkedHashMap<>();
        car1.forward();
        racingCarResult1.put(car1, car1.getPosition());
        racingCarResult1.put(car2, car2.getPosition());
        RacingResult racingResult1 = new RacingResult(racingCarResult1);
        racingResults.setResult(racingResult1);

        Map<Car, Integer> racingCarResult2 = new LinkedHashMap<>();
        car1.forward();
        car2.forward();
        racingCarResult2.put(car1, car1.getPosition());
        racingCarResult2.put(car2, car2.getPosition());
        RacingResult racingResult2 = new RacingResult(racingCarResult2);
        racingResults.setResult(racingResult2);

    }

    @DisplayName("레이싱 결과를 보관하고 있는 객체들의 사이즈를 확인")
    @Test
    void checkResultFactorySize() {
        assertThat(racingResults.size()).isEqualTo(2);
    }

    @DisplayName("해당 회차의 레이싱 결과 리턴")
    @Test
    void checkResultFactoryReturn() {
        assertThat(racingResults.getEpisodeResult(1).get(car1)).isEqualTo(1);
        assertThat(racingResults.getEpisodeResult(1).get(car2)).isEqualTo(0);
        assertThat(racingResults.getEpisodeResult(2).get(car1)).isEqualTo(2);
        assertThat(racingResults.getEpisodeResult(2).get(car2)).isEqualTo(1);
    }

}
