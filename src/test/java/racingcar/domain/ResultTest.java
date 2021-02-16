package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Position;
import racingcar.domain.result.Result;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = Arrays.asList(Car.of(CarName.valueOf("park"), Position.valueOf(2)),
                Car.of(CarName.valueOf("kim"), Position.valueOf(4)),
                Car.of(CarName.valueOf("lee"), Position.valueOf(6)),
                Car.of(CarName.valueOf("im"), Position.valueOf(6))
        );
    }

    @Test
    @DisplayName("Result 생성된다.")
    public void createResultTest() {
        Result result = Result.of(cars);

        List<Car> carsResult = result.getResult();

        assertThat(carsResult.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("최대 전진거리를 구한다.")
    public void getMaxPositionTest() {
        //given
        Result result = Result.of(cars);

        //when
        Position maxPosition = result.getMaxPosition();

        //then
        assertThat(maxPosition).isEqualTo(Position.valueOf(6));
    }

    @Test
    @DisplayName("우승자를 구한다.")
    public void getWinnersTest() {
        //given
        Result result = Result.of(cars);

        //when
        List<String> winners = result.getWinners();

        //then
        assertThat(winners).contains("lee", "im");
    }
}
