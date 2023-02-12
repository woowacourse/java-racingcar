package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarsTest {

    private Cars cars;
    private Rule rule = Rule.MOVING_FORWARD_STANDARD;

    class TestValueGenerator implements ValueGenerator {

        private int generateCount = 0;

        @Override
        public int generate() {
            generateCount++;
            if (generateCount % 3 == 2) {
                return 2;
            }
            return 6;
        }
    }

    @BeforeEach
    void setup() {
        cars = new Cars(List.of(
                new Car("test1"),
                new Car("test2"),
                new Car("test3")
        ));

        for (int i = 0; i < 5; i++) {
            cars.moveCars(new TestValueGenerator(), new StandardRacingRule());
        }
    }


    @Test
    @DisplayName("라운드 결과 테스트")
    void getRoundResultTest() {

        Map<String, Integer> actualResult = cars.getRoundResult();

        assertSoftly(softly -> {
            softly.assertThat(actualResult.get("test1")).isEqualTo(5);
            softly.assertThat(actualResult.get("test2")).isEqualTo(0);
            softly.assertThat(actualResult.get("test3")).isEqualTo(5);
        });
    }

    @Test
    @DisplayName("라운드 수 확인 테스트")
    void getCurrentRoundTest() {
        assertThat(cars.getCurrentRound()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자를 확인하는 기능 테스트")
    void getWinnersTest() {
        assertThat(cars.getWinners()).containsExactly("test1", "test3");
    }
}
