package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.ParticipatedCars;

@SuppressWarnings("NonAsciiCharacters")
public class ParticipatedCarsTest {

    private ParticipatedCars participatedCars = new racingcar.domain.ParticipatedCars();

    @Test
    public void 자동차_생성_테스트() {
        participatedCars.generateCars(Arrays.asList("이브", "클레이", "포비"));
        assertThat(participatedCars.getSize()).isEqualTo(3);
    }

    @Test
    public void 최종_우승자_찾기_테스트() {
        participatedCars.addCar(new Car("이브"));
        participatedCars.addCar(new Car("클레이"));
        participatedCars.addCar(new Car("포비"));
        participatedCars.executeCarRacing();
        participatedCars.findWinners();
        List<String> winners = participatedCars.findWinners().getWinnerNames();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains("이브", "포비");
    }
}
