package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("경기 진행 테스트(1턴)")
    void playTurnTest() {
        TestNumberGenerator test = new TestNumberGenerator(new int[]{4, 2, 3, 9, 5});
        CarFactory carFactory = new CarFactory("alan, bart, carol, don, eddy");
        Cars cars = carFactory.enrollCars();
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
        TestNumberGenerator test = new TestNumberGenerator(new int[]{4, 2, 5});
        CarFactory carFactory = new CarFactory("alan, bart, carol");
        Cars cars = carFactory.enrollCars();
        cars.playTurn(test);
        assertThat(cars.findWinner()).containsExactly("alan", "carol");
    }
}
