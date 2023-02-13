package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.List;
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

        car1.move(true);
        car2.move(true);
        car3.move(false);

        car1.move(true);
        car2.move(true);
        car3.move(false);

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

        assertThat(firstTurnCount + 1 == secondTurnCount).isTrue();
    }

    @Test
    @DisplayName("라운드 결과 테스트")
    void getRoundResultTest() {
        List<Map.Entry<String, Integer>> actualResult = cars.getRoundResult().getRoundResult();

        assertSoftly(softly -> {
            softly.assertThat(actualResult.get(0).getValue()).isEqualTo(2);
            softly.assertThat(actualResult.get(1).getValue()).isEqualTo(2);
            softly.assertThat(actualResult.get(2).getValue()).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("우승자를 확인하는 기능 테스트")
    void getWinnersTest() {
        assertThat(cars.getWinners().getWinners()).containsExactly("test1", "test2");
    }
}