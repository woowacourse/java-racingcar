package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars();
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");

        car1.move(4);
        car2.move(7);
        car3.move(1);

        car1.move(9);
        car2.move(8);
        car3.move(2);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

    }

    @Test
    @DisplayName("자동차들의 라운드 진행 테스트")
    void getTurnCountTest() {
        int firstTurnCount = cars.getTurnCount();

        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        cars.playRound(randomValueGenerator);

        int secondTurnCount = cars.getTurnCount();

        cars.playRound(randomValueGenerator);

        int thirdTurnCount = cars.getTurnCount();

        assertSoftly(softly -> {
            softly.assertThat(firstTurnCount).isEqualTo(2);
            softly.assertThat(secondTurnCount).isEqualTo(3);
            softly.assertThat(thirdTurnCount).isEqualTo(4);
        });
    }

    @Test
    @DisplayName("라운드 결과 테스트")
    void getRoundResultTest() {
        Map<String, Integer> actualResult = cars.getRoundResult();

        assertSoftly(softly -> {
            softly.assertThat(actualResult.get("test1")).isEqualTo(2);
            softly.assertThat(actualResult.get("test2")).isEqualTo(2);
            softly.assertThat(actualResult.get("test3")).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("우승자를 확인하는 기능 테스트")
    void getWinnersTest() {
        assertThat(cars.getWinners()).containsExactly("test1", "test2");
    }
}