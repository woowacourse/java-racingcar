package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.ParticipatedCars;

@SuppressWarnings("NonAsciiCharacters")
public class ParticipatedCarsTest {

    private ParticipatedCars participatedCars;

    @BeforeEach
    void setCars() {
        participatedCars = new ParticipatedCars();
        participatedCars.generateCars(Arrays.asList("이브", "클레이", "포비"));
    }

    @Test
    public void 자동차_생성_테스트() {

        assertThat(participatedCars.getCars().size()).isEqualTo(3);
    }

    @Test
    public void 최종_우승자_찾기_테스트() {
        participatedCars.executeCarRacing();
        List<String> winners = participatedCars.findWinners().getWinnerNames();

        List<Car> cars = participatedCars.getCars();
        Collections.sort(cars, (faster, slower) -> slower.getPosition() - faster.getPosition());

        assertThat(winners.get(winners.size() - 1))
                .isEqualTo(cars.get(cars.size() - 1).getName());
    }
}
