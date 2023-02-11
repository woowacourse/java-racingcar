package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.RacingcarService;

class RacingcarServiceTest {

    private final RacingcarService racingcarService = new RacingcarService();
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void initCars() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");
    }

    @Test
    @DisplayName("우승 자동차 위치 확인하기")
    void findWinnerPosition() {
        car2.move(5);
        car3.move(5);

        List<Car> cars = Arrays.asList(car1, car2, car3);

        int winnerPosition = findWinnerPosition(cars, racingcarService);

        assertThat(winnerPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 확인하기")
    void findWinner() {
        car2.move(5);
        car3.move(5);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        int winnerPosition = findWinnerPosition(cars, racingcarService);
        List<Car> winners = racingcarService.findWinner(cars, winnerPosition);

        assertThat(winners).containsExactly(car2, car3);
    }

    private int findWinnerPosition(List<Car> cars, RacingcarService racingcarService) {
        return racingcarService.findPosition(cars);
    }
}
