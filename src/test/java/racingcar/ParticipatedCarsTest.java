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
import racingcar.domain.WinnerNames;
import racingcar.util.BoundedRandomNumberGenerator;
import racingcar.util.MovableNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class ParticipatedCarsTest {

    private ParticipatedCars participatedCars;

    @BeforeEach
    void setCars() {
        participatedCars = new ParticipatedCars(Arrays.asList("이브", "클레이", "포비"));
    }

    @Test
    public void 자동차_생성_테스트() {
        assertThat(participatedCars.getCars().size()).isEqualTo(3);
    }

    @Test
    public void 자동차_작동_테스트() {
        participatedCars.executeCarRacing(new MovableNumberGenerator());
        List<Car> cars = participatedCars.getCars();
        for (int i = 0 ; i < cars.size() ; i++) {
            assertThat(cars.get(i).getPosition()).isEqualTo(1);
        }
    }

    @Test
    public void 최종_우승자_찾기_테스트() {
        participatedCars.executeCarRacing(new BoundedRandomNumberGenerator(9, 0));
        List<String> winners = WinnerNames.of(participatedCars).getWinnerNames();

        List<Car> cars = participatedCars.getCars();
        Collections.sort(cars, (faster, slower) -> slower.getPosition() - faster.getPosition());

        int winnerIndex = winners.size() - 1;
        assertThat(winners.get(winnerIndex)).isEqualTo(cars.get(winnerIndex).getName());
    }
}
