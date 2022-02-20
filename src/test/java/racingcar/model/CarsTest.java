package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "deprecation"})
public class CarsTest {

    private Cars cars;

    @DisplayName("우승자 확인 테스트")
    @Test
    void getWinnerTest() {
        cars = new Cars(new String[]{"A", "B", "C"});
        cars.getCars()
                .get(0)
                .move(() -> 5);
        assertThat(cars.getWinner()).contains("A");
    }

    @DisplayName("다중 우승자 확인 테스트")
    @Test
    void getWinnersTest() {
        cars = new Cars(new String[]{"A", "B", "C"});
        assertThat(cars.getWinner()).contains("A", "B", "C");
    }

    @DisplayName("자동차 저장 확인 테스트")
    @Test
    void carsGenerationTest() {
        cars = new Cars(new String[]{"A"});
        Car carA = new Car("A", 0);
        assertThat(cars.getCars()
                .get(0))
                .isEqualToComparingFieldByField(carA);
    }
}
