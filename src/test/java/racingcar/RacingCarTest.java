package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private static Game game;
    private static Cars cars;

    @BeforeEach
    public void init() {
        CarFactory carFactory = new CarFactory("alan, bart, carol, don, eddy");
        cars = carFactory.enrollCars();
        game = new Game(cars, 5);
    }

    @Test
    @DisplayName("경기 진행 테스트(1턴)")
    void gameProceedTest() {
        TestNumberGenerator test = new TestNumberGenerator(new int[]{4, 2, 3, 9, 5});
        cars.playTurn(test);
        assertThat(cars.notifyStatus().get("alan")).isEqualTo("-");
        assertThat(cars.notifyStatus().get("bart")).isEqualTo("");
        assertThat(cars.notifyStatus().get("carol")).isEqualTo("");
        assertThat(cars.notifyStatus().get("don")).isEqualTo("-");
        assertThat(cars.notifyStatus().get("eddy")).isEqualTo("-");
    }

    @Test
    @DisplayName("결과 발표 테스트")
    void getResultTest() {
        TestNumberGenerator test = new TestNumberGenerator(new int[]{4, 2, 3, 9, 5});
        cars.playTurn(test);
        assertThat(cars.findWinner()).containsExactly("alan", "don", "eddy");
    }
}